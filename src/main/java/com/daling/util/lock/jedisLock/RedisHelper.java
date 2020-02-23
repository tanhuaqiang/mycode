package com.daling.util.lock.jedisLock;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author tanhq
 */
public class RedisHelper {
	private final static Logger log = LoggerFactory.getLogger(RedisHelper.class);

	private final static String REDIS_SVR_LIST;
	// Redis服务器IP
	private final static String ADDR;
	// Redis的端口号
	private final static int PORT;
	// 访问密码
	//private static String AUTH = "admin";

	// 可用连接实例的最大数目，默认值为8；
	// 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
	private final static int MAX_ACTIVE;
	// 最小保持的idle连接, 默认为0, 保持一定的链接, 有利于快速获取jedis, 避免建立tcp连接的消耗。
	private final static int MIN_IDLE;
	// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
	private final static int MAX_IDLE;
	// 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
	private final static int MAX_WAIT;
	
	private final static int TIMEOUT;
	// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的
	private final static boolean TEST_ON_BORROW;

	private static JedisPool jedisPool;

	public static final ObjectMapper mapper = new ObjectMapper();

	static {
		try {
			PropertiesConfiguration config = new PropertiesConfiguration("redis2s.properties");
			String radisstr = config.getString("redis.server.list","");
			String serverlist = config.getString("SERVER_LIST","");
			REDIS_SVR_LIST = (StringUtils.isNotBlank(serverlist)) ? serverlist : radisstr;

			ADDR = StringUtils.split(REDIS_SVR_LIST,":")[0];
			//这里格式不对会报数组越界错误, 需要catch到
			PORT = NumberUtils.toInt(StringUtils.split(REDIS_SVR_LIST,":")[1]);
			// 如果赋值为-1，则表示不限制
			MAX_ACTIVE = NumberUtils.toInt(config.getString("MAX_ACTIVE"), -1);
			MIN_IDLE =  NumberUtils.toInt(config.getString("MIN_IDLE"), 10);
			MAX_IDLE = NumberUtils.toInt(config.getString("MAX_IDLE"), 50);
			MAX_WAIT = NumberUtils.toInt(config.getString("MAX_WAIT"), 5000);
			TIMEOUT = NumberUtils.toInt(config.getString("TIMEOUT"), 5000);
			TEST_ON_BORROW = BooleanUtils.toBoolean(config.getString("TEST_ON_BORROW"));

			JedisPoolConfig jedisConfig = new JedisPoolConfig();
			jedisConfig.setMaxTotal(MAX_ACTIVE);
			jedisConfig.setMinIdle(MIN_IDLE);
			jedisConfig.setMaxIdle(MAX_IDLE);
			jedisConfig.setMaxWaitMillis(MAX_WAIT);
			jedisConfig.setTestOnBorrow(TEST_ON_BORROW);

			jedisPool = new JedisPool(jedisConfig, ADDR, PORT, TIMEOUT);


		} catch (Exception exc) {
			log.error("GlobalConfigurationException", exc);
			throw new RuntimeException(exc);
		}
	}
	
	/**
	 * 获取Jedis实例
	 * 
	 * @return
	 */
	public synchronized  static Jedis getJedis() {
		try {
			if (jedisPool != null) {
				Jedis resource = jedisPool.getResource();
				return resource;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 释放jedis资源
	 * 
	 * @param jedis
	 */
	public static void returnResource(Jedis jedis){
		jedis.close();
		jedis = null;
	}
	/**
	 * 释放jedis资源
	 */
	public static void close() {
		if (null != jedisPool && !jedisPool.isClosed()) {
			jedisPool.close();
		}
	}

	public static boolean isClosed() {
		return null != jedisPool ? jedisPool.isClosed() : true;
	}	

}
