package com.daling.util.lock.jedisLock;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;

import com.google.common.base.Preconditions;

/**
 * @author tanhq
 */
public class RedisLock implements RdLock {

	private static final Logger log = LoggerFactory.getLogger(RedisLock.class);

	private static final String LOCKNAME_PREFIX = "dal_rlock_";

	/**
	 * 表示当key不存在时，创建key并保存value
	 * 当key存在时，不做操作
	 */
	private static final String setMode_NX = "NX";

	/**
	 * 当key存在时，保存value
	 * 当key不存在时，不做操作
	 */
	private static final String setMode_XX = "XX";

	/**
	 * key的有效期为秒
	 */
	private static final String expTimeunits_EX = "EX";

	/**
	 * key的有效期为毫秒
	 */
	private static final String expTimeunits_PX = "PX";

    public static final Random RANDOM = new Random();

	/**
	 * 锁的失效时间
	 */
	public static final long LOCK_EXPIRATION_INTERVAL_SECONDS = 60;
	
	protected long internalLockLeaseTime = TimeUnit.SECONDS.toMillis(LOCK_EXPIRATION_INTERVAL_SECONDS);

	// 锁状态标志
	private boolean locked = false;

	private final String lockKey;
	private final String uuidValue;
	private Jedis myJedis = null;

	public RedisLock(Jedis jedis, String name) {
		this.lockKey = LOCKNAME_PREFIX + name;
		this.myJedis = jedis;
		this.uuidValue = UUID.randomUUID().toString() + "-" + Thread.currentThread().getId();
	}

	@Override
	public void close() {
		unlock();
		if (myJedis != null) {
			myJedis.close();
		}
		myJedis = null;
	}

	@Override
	public boolean tryLock() {

		//锁的失效时间
		return locked ? locked : (this.tryLockInner(LOCK_EXPIRATION_INTERVAL_SECONDS, TimeUnit.SECONDS) == null);
	}

	@Override
	public boolean tryLock(long leaseTime, TimeUnit unit) {
		return locked ? locked : (this.tryLockInner(leaseTime, unit) == null);
	}

	/**
	 * @param leaseTime 锁的失效时间
	 * @param unit
	 * @return null:获取锁成功, 正整数:其他人获取锁的生命时长, -2:key不存在但是创建锁失败, -1:有key但无生命周期值
	 */
	private Long tryLockInner(final long leaseTime, final TimeUnit unit) {
		Preconditions.checkNotNull(myJedis != null, "myJedis is null");
		long lockLeaseTime = 0;
		if (leaseTime != -1) {
			lockLeaseTime = unit.toMillis(leaseTime);
		} else {
			lockLeaseTime = internalLockLeaseTime;
		}
		// set(String key, String value, String nxxx, String expx, long time)
		//使用redis中setnx保证资源的原子性操作
		String rtnCode = this.myJedis.set(lockKey, uuidValue, setMode_NX, expTimeunits_PX, lockLeaseTime);
//		log.debug("SET_NX_PX, rtnCode={}",rtnCode);

		// SETNX成功，则成功获取一个锁
		if (StringUtils.equals(rtnCode, "OK")) {
			locked = true;
//			log.info("OK:{}={}, ttl={}", lockKey, myJedis.get(lockKey), myJedis.pttl(lockKey));
			return null;
		} else {
			// SETNX失败，说明锁已存在,检查是否被自己保持,还是被其他对象保持，检查其是否已经超时
//			log.info("NA:{}={}, ttl={}", lockKey, myJedis.get(lockKey), myJedis.pttl(lockKey));
			// 当 key 不存在时，返回 -2 。
			// 当 key 存在但没有设置剩余生存时间时，返回 -1 。
			// 否则，以毫秒为单位，返回 key 的剩余生存时间。
			return myJedis.pttl(lockKey);
		}
	}


	@Override
	public void unlock() {
		if (locked) {
			myJedis.del(lockKey);
		}
		locked = false;
	}

	@Override
	public boolean isLocked() {
		return myJedis.exists(lockKey);
	}

	@Override
	public boolean isHoldByCurrentThread() {
		return StringUtils.equals(myJedis.get(lockKey), uuidValue);
	}


}
