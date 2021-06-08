package com.dalingjia.redis;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.params.SetParams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJedis {

    public static void main(String[] args) {
//        Jedis jedis = new Jedis("172.18.152.189", 6379);
        Jedis jedis = new Jedis("192.168.199.166", 6379);

        System.out.println(jedis.ping());
        jedis.close();
    }

    private Jedis jedis;

    @Before
    public void initJedis() {
        jedis = new Jedis("172.18.152.189", 6379);
    }

    @Test
    public void testKey() {
        //查询0号库
        System.out.println(jedis.keys("*"));
        System.out.println(jedis.exists("k1"));
        jedis.expire("k1", 60);
        System.out.println(jedis.ttl("k1"));
        System.out.println(jedis.type("k1"));

        System.out.println(jedis.incr("count"));
        System.out.println(jedis.incr("count"));
        System.out.println(jedis.incr("count"));
        System.out.println(jedis.decr("count"));
        System.out.println(jedis.decr("count"));
        System.out.println(jedis.decr("count"));

        System.out.println(jedis.incrBy("count", 2));
        System.out.println(jedis.incrBy("count", 2));

    }

    @Test
    public void testString() {
        System.out.println(jedis.set("k1", "v2"));
        System.out.println(jedis.get("k1"));
        System.out.println(jedis.del("k1"));

        System.out.println(jedis.append("k1", "v1"));
        System.out.println(jedis.append("k1", "v1"));
        System.out.println(jedis.get("k1"));
        System.out.println(jedis.strlen("k1"));
        System.out.println(jedis.mset("k1", "v1", "k2", "v2", "k3", "v3"));
        System.out.println(jedis.mget("k1", "k2", "k3"));

        System.out.println(jedis.setnx("k1", "kkkkk"));
        System.out.println(jedis.get("k1"));

        System.out.println(jedis.setex("k9", 60, "v9"));
        System.out.println(jedis.ttl("k9"));

        System.out.println("===============");
        SetParams setParams = new SetParams();
        setParams.ex(100);
        setParams.nx();
        //其中NX表示使用NX模式，PX表示过期时间的单位是毫秒
//        System.out.println(jedis.set("kll", "kll", "NX", "PX", 10000));
        System.out.println(jedis.set("kll", "kll", setParams));
        System.out.println(jedis.ttl("kll"));
    }

    @Test
    public void testList() {
        //列表采用左插入
        System.out.println(jedis.lpush("lpush", "v1", "v2", "v3", "v4"));
        System.out.println(jedis.rpush("rpush", "v1", "v2", "v3", "v4"));
        System.out.println(jedis.lrange("lpush", 0, -1));
        System.out.println(jedis.lrange("rpush", 0, -1));

        System.out.println(jedis.rpop("lpush"));
        System.out.println(jedis.rpop("rpush"));

        System.out.println(jedis.lpop("lpush"));
        System.out.println(jedis.lpop("rpush"));
    }

    @Test
    public void testSet() {
        System.out.println(jedis.sadd("set1", "v1", "v2", "v3", "v4", "v5", "v6", "v7"));
        System.out.println(jedis.smembers("set1"));
        System.out.println(jedis.sismember("set1", "v1"));

        System.out.println(jedis.sadd("set2", "v1", "v2", "v3", "v4", "v11", "v12"));
        //在第一个set里面而不再第二个set里面（差集）
        System.out.println(jedis.sdiff("set1", "set2"));
        System.out.println(jedis.sinter("set1", "set2"));
        System.out.println(jedis.sunion("set1", "set2"));
    }

    @Test
    public void testHash() {
        Map<String, String> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");
        System.out.println(jedis.hset("hash", map));
        System.out.println(jedis.hkeys("hash"));
        System.out.println(jedis.hvals("hash"));
        System.out.println(jedis.hget("hash", "k1"));
        System.out.println(jedis.hgetAll("hash"));
    }

    @Test
    public void testZset() {
        Map<String, Double> map = new HashMap<>();
        map.put("k1", 10d);
        map.put("k4", 40d);
        map.put("k3", 30d);
        map.put("k2", 20d);
        System.out.println(jedis.zadd("zset", map));
        System.out.println(jedis.zrange("zset", 0, -1));
        System.out.println(jedis.zrangeWithScores("zset", 0, -1));

    }


    @Test
    public void testScan() {
        //初始游标为0
        this.methodScan("0");
    }

    private void methodScan(String cursor) {
        String key = "k*";
        ScanParams scanParams = new ScanParams();
        scanParams.match(key);
        scanParams.count(2);
        ScanResult<String> scanResult = jedis.scan(cursor, scanParams);
        cursor = scanResult.getCursor();
        System.out.println("返回游标为：" + cursor);
        List<String> list = scanResult.getResult();
        for (int i = 0; i < list.size(); i++) {
            String mapentry = list.get(i);
            System.out.println("查询出key:" + mapentry);
        }
        System.out.println("=================");
        if (!"0".equals(cursor)) {
            this.methodScan(cursor);
        }
    }
}

