package com.daling.util.lock.zkLock;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.curator.RetryLoop;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.imps.CuratorFrameworkState;
import org.apache.curator.framework.recipes.locks.PredicateResults;
import org.apache.curator.utils.ZKPaths;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * zk 阻塞锁
 */
public class ZookeeperLock implements ZkLock {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    public final static String UNDER_LINE = "_";
    public final static String PREFIX_MID_PATH = "zklocking2";
    public final static String BASE_PATH = "/daling_zk";

    private final CuratorFramework client;
    private String baseLockPath = ZKPaths.makePath(BASE_PATH, PREFIX_MID_PATH);;
    private final String lockName;
    private final String lockPath;
    private String selfPath;
    private final String uuidValue;

    private final ThreadLocal<ZookeeperLock.MyLockData> threadData = new ThreadLocal<ZookeeperLock.MyLockData>();

    public ZookeeperLock(CuratorFramework client, String thisLockName) {
        this.client = client;
        this.lockName = thisLockName + UNDER_LINE;
        this.lockPath = ZKPaths.makePath(baseLockPath, thisLockName + UNDER_LINE);
        this.uuidValue = UUID.randomUUID().toString();
    }

    @Override
    public void lock() throws Exception {
        if (!tryLock(-1, null)) {
            throw new Exception("Lost connection while trying to acquire lock: " + baseLockPath);
        }
    }

    @Override
    public boolean tryLock() throws Exception {
        return tryLock(0L, TimeUnit.MILLISECONDS);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws Exception {
        ZookeeperLock.MyLockData lockData = threadData.get();
        if (lockData != null) {
            // re-entering
            //非重入锁, 不计数
            return true;
        } else {
            String lockPath = attemptLock(time, unit);
            if (lockPath != null) {
                threadData.set(new ZookeeperLock.MyLockData(uuidValue, lockPath));
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 创建临时节点, 等待获取锁
     * @param time
     * @param unit
     * @return
     * @throws Exception
     */
    private String attemptLock(long time, TimeUnit unit) throws Exception {
        final long startMillis = System.currentTimeMillis();
        final Long millisToWait = (unit != null) ? unit.toMillis(time) : null;
        int retryCount = 0;

        boolean hasTheLock = false;
        boolean isDone = false;
        while (!isDone) {
            isDone = true;
            try {
                //.create() 创建节点
                //.creatingParentsIfNeeded() 创建父节点,如果需要的话
                //.withMode(CreateMode.xxx) 节点属性:永久节点/永久有序节点/临时节点/临时有序节点(CreateMode.EPHEMERAL_SEQUENTIAL) 通过CreateMode.即可看到
                //.forPath(lockPath) 指明你的节点路径
                selfPath = client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath(lockPath);
                log.info("创建锁路径:{}",  selfPath);

                hasTheLock = internalLockLoop(startMillis, millisToWait);
            } catch (KeeperException.NoNodeException e) {
                if (client.getZookeeperClient().getRetryPolicy().allowRetry(retryCount++, System.currentTimeMillis() - startMillis, RetryLoop.getDefaultRetrySleeper())) {
                    isDone = false;
                } else {
                    throw e;
                }
            }
        }
        if (hasTheLock) {
            return selfPath;
        }
        return null;
    }

    /**
     *
     * 循环检查临时节点队列, 获取自己为序号最小节点后, 获得锁退出
     *
     * @param startMillis
     * @param millisToWait
     * @return
     * @throws Exception
     */
    private boolean internalLockLoop(long startMillis, Long millisToWait) throws Exception {
        boolean haveTheLock = false;
        boolean doDelete = false;
        try {
            while ((client.getState() == CuratorFrameworkState.STARTED) && !haveTheLock) {
                PredicateResults checkMinPathResult = checkMinPath();
                if (checkMinPathResult.getsTheLock()) {
                    haveTheLock = true;
                } else {
                    String waitPath = checkMinPathResult.getPathToWatch();
                    synchronized (this) {
                        try {
                            // 用 getData()替代exists()以避免泄露watchers资源
                            client.getData().usingWatcher(watcher).forPath(waitPath);
                            if (millisToWait != null) {
                                millisToWait -= (System.currentTimeMillis() - startMillis);
                                startMillis = System.currentTimeMillis();
                                if (millisToWait <= 0) {
                                    // 过期, 删除当前锁节点
                                    doDelete = true;
                                    break;
                                }
                                wait(millisToWait);
                            } else {
                                wait();
                            }
                        } catch (KeeperException.NoNodeException e) {
                            // it has been deleted (i.e. lock released). Try to acquire again
                        }
                    }
                }
            }
        } catch (Exception e) {
            doDelete = true;
            throw e;
        } finally {
            if (doDelete) {
                innerReleaseLock(selfPath);
            }
        }
        return haveTheLock;
    }

    /**
     * 检查自己是不是最小的节点
     *
     * @return
     * @throws Exception
     */
    public PredicateResults checkMinPath() throws Exception {
        String waitPath = null;

        List<String> children = client.getChildren().forPath(baseLockPath);
        // 要过滤出lockName开头的节点, 其他lock也在同一basePath目录下, 不需要参与排序和计算
        Lists.newArrayList(children);
        List<String> subNodes = Lists.newArrayList();
        int indx = 0;
        for (String item : children) {
            if ((indx = item.lastIndexOf(UNDER_LINE)) > 0 && StringUtils.equals(item.substring(0, indx + 1), lockName)) {
                subNodes.add(item);
            }
        }

        Collections.sort(subNodes);
        int lockIndex = subNodes.indexOf(selfPath.substring(baseLockPath.length() + 1));

        switch (lockIndex) {
            case -1: {
                throw new KeeperException.NoNodeException("Sequential path not found: " + selfPath);
            }
            case 0: {
                return new PredicateResults(null, true);
            }
            default: {
                waitPath = baseLockPath + "/" + subNodes.get(lockIndex - 1);
                return new PredicateResults(waitPath, false);
            }
        }
    }

    @Override
    public void unlock() throws Exception {
        ZookeeperLock.MyLockData lockData = threadData.get();
        if (lockData == null) {
            return;
        }
        try {
            innerReleaseLock(lockData.lockPath);
        } finally {
            threadData.remove();
        }
    }

    @Override
    public void close() {
        try {
            unlock();
        } catch (Exception e) {
            log.error("ZLock Close", e);
        }
    }

    /**
     * client
     * .delete() //删除
     * .guaranteed()//保证一定帮你删了它
     * .withVersion(0)//指定要删节点的版本号
     * .forPath("/yourpath")//指定要删节点的路径
     * @param lockPath
     * @throws Exception
     */
    private void innerReleaseLock(String lockPath) throws Exception {
        try {
            client.delete().guaranteed().forPath(lockPath);
        } catch (KeeperException.NoNodeException e) {
            log.info(e.getMessage(), e);
        }
    }

    /**
     * 唤醒其他等待锁的线程
     */
    private synchronized final void notifyFromWatcher() {
        notifyAll();
    }

    private static class MyLockData {

        final String trackID;
        final String lockPath;

        private MyLockData(String trackID, String lockPath) {
            this.trackID = trackID;
            this.lockPath = lockPath;
        }
    }

    private final Watcher watcher = new Watcher() {
        @Override
        public void process(WatchedEvent event) {
            notifyFromWatcher();
        }
    };

}
