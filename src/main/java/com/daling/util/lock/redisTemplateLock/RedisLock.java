package com.daling.util.lock.redisTemplateLock;

import org.springframework.data.redis.core.RedisTemplate;

import java.io.Closeable;
import java.io.IOException;

public class RedisLock implements Closeable {
	 
    private RedisTemplate<String,Object> redisTemplate;
    /**
     * 重试时间
     */
    private static final int DEFAULT_ACQUIRY_RETRY_MILLIS = 100;
    /**
     * 锁的前缀
     */
	private  final String LOCK_PREFFIX = "redisTemplate_";
    /**
     * 锁的key
     */
    private String lockKey;
    /**
     * 锁失效时间，防止线程在入锁以后，阻塞后面的线程无法获取锁
     */
    private int expireMsecs = 60 * 1000;
//    private int expireMsecs = 1 * 1000;
    /**
     * 线程获取锁的等待时间60s
     */
    private int timeoutMsecs = 60 * 1000;
    /**
     * 是否锁定标志
     */
    private boolean locked = false;
    
    /**
     * 构造器
     * @param redisTemplate
     * @param lockKey 锁的key
     */
    public RedisLock(RedisTemplate<String,Object> redisTemplate, String lockKey) {
        this.redisTemplate = redisTemplate;
        this.lockKey = LOCK_PREFFIX + lockKey;
    }
 
    /**
     * 构造器
     * @param redisTemplate
     * @param lockKey 锁的key
     * @param timeoutMsecs 获取锁的超时时间
     */
    public RedisLock(RedisTemplate<String,Object> redisTemplate, String lockKey, int timeoutMsecs) {
        this(redisTemplate, lockKey);
        this.timeoutMsecs = timeoutMsecs;
    }
 
    /**
     * 构造器
     * @param redisTemplate
     * @param lockKey 锁的key
     * @param timeoutMsecs 获取锁的超时时间
     * @param expireMsecs 锁的有效期
     */
    public RedisLock(RedisTemplate<String,Object> redisTemplate, String lockKey, int timeoutMsecs, int expireMsecs) {
        this(redisTemplate, lockKey, timeoutMsecs);
        this.expireMsecs = expireMsecs;
    }
 
    public String getLockKey() {
        return lockKey;
    }
 
    /**
     * 封装和jedis方法
     * @param key
     * @return
     */
    private String get(final String key) {
        Object obj = redisTemplate.opsForValue().get(key);
        return obj != null ? obj.toString() : null;
    }
 
    /**
     * 封装和jedis方法
     * @param key
     * @param value
     * @return
     */
    private boolean setNX(final String key, final String value) {
        return redisTemplate.opsForValue().setIfAbsent(key,value);
    }
 
    /**
     * 封装和jedis方法
     * @param key
     * @param value
     * @return
     */
    private String getSet(final String key, final String value) {
        Object obj = redisTemplate.opsForValue().getAndSet(key,value);
        return obj != null ? (String) obj : null;
    }
 
    /**
     * 获取锁
     * @return 获取锁成功返回ture，超时返回false
     * @throws InterruptedException
     */
    public boolean lock() throws InterruptedException {
        // 线程获取锁的等待时间60s
        int timeout = timeoutMsecs;
        while (timeout >= 0) {
            //锁的失效时间，到期时间(60s)
            long expires = System.currentTimeMillis() + expireMsecs + 1;
            String expiresStr = String.valueOf(expires);
            //原子操作
            if (this.setNX(lockKey, expiresStr)) {
                locked = true;
                return true;
            }
            //redis里key的值
            String currentValue = this.get(lockKey);
            //判断锁是否已经过期，过期则重新设置并获取
            if (currentValue != null && Long.parseLong(currentValue) < System.currentTimeMillis()) {
                //设置锁并返回旧值，redis里key的值
                String oldValue = this.getSet(lockKey, expiresStr);
                //比较锁的时间，如果不一致则可能是其他锁已经修改了值并获取
                if (oldValue != null && oldValue.equals(currentValue)) {
                    locked = true;
                    return true;
                }
            }
            timeout -= DEFAULT_ACQUIRY_RETRY_MILLIS;
            //延时100毫秒
            Thread.sleep(DEFAULT_ACQUIRY_RETRY_MILLIS);
        }
        return false;
    }
    /**
     * 释放获取到的锁
     */
    public void unlock() {
        if (locked) {
            redisTemplate.delete(lockKey);
            locked = false;
        }
    }

	@Override
	public void close() throws IOException {
		if (locked) {
            redisTemplate.delete(lockKey);
            locked = false;
        }
	}
    
 
}