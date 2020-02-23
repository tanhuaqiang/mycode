package com.daling.util.lock;


import com.daling.util.lock.jedisLock.RdLock;
import com.daling.util.lock.jedisLock.RedisHelper;
import com.daling.util.lock.jedisLock.RedisLock;
import com.daling.util.lock.zkLock.ZkHelper;
import com.daling.util.lock.zkLock.ZkLock;
import com.daling.util.lock.zkLock.ZookeeperLock;
import com.google.common.base.Preconditions;

/**
 * @author tanhq
 */
public class LockUtils {

    /**
     * 获取 Jedis 封装的 Redis锁
     * @param lockName
     * @return
     */
    public static RdLock getRLock(String lockName) {
        Preconditions.checkNotNull(lockName, "redisLockName should not be null");
        return new RedisLock(RedisHelper.getJedis(), lockName);
    }

    /**
     *
     * @param lockName
     * @return
     */
    public static ZkLock getZLock(String lockName) {
        Preconditions.checkNotNull(lockName, "zkLockName should not be null");
        return new ZookeeperLock(ZkHelper.getZkClient(), lockName);
    }
}
