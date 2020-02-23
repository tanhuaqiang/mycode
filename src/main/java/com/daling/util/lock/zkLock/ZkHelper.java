package com.daling.util.lock.zkLock;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZkHelper {

    private static Logger log = LoggerFactory.getLogger(ZkHelper.class);

    public static String ZK_CONNECT_ADDRESS;
    public static String BASE_PATH;

    static {
        try {
            PropertiesConfiguration config = new PropertiesConfiguration();
            config.setEncoding("UTF-8");
            config.setThrowExceptionOnMissing(true);
            config.load("zk2s.properties");

            ZK_CONNECT_ADDRESS = config.getString("zk.server.list");
            BASE_PATH = config.getString("base.path","/daling_zk");
        } catch (org.apache.commons.configuration.ConfigurationException exc) {
            log.error("GlobalConfigurationException", exc);
            throw new RuntimeException(exc);
        }
    }

    private CuratorFramework zkClient;

    /**
     */
    private ZkHelper() {
        init();
    }

    /**
     */
    private static class ZkHelperHolder {
        private static ZkHelper instance = new ZkHelper();
    }

    /**
     */
    private static ZkHelper getInstance() {
        return ZkHelper.ZkHelperHolder.instance;
    }

    /**
     */
    private void init() {
        //1、重试策略：初试时间为1s 重试3次
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        //2、通过工厂创建连接，初始化生成zkClient
        this.zkClient = CuratorFrameworkFactory.newClient(ZK_CONNECT_ADDRESS, retryPolicy);
        //3、开启连接
        zkClient.start();
    }

    /**
     * @return CuratorFramework
     */
    public static CuratorFramework getZkClient() {
        return ZkHelper.getInstance().zkClient;
    }

    /**
     *
     */
    public static void releasezkClient() {
        try {
            if (ZkHelper.getInstance().zkClient != null) {
                CloseableUtils.closeQuietly(ZkHelper.getInstance().zkClient);
            }
        } catch (Throwable e) {
            // ignore
        }
        ZkHelper.getInstance().zkClient = null;
    }


}
