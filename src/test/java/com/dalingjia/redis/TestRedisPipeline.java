package com.dalingjia.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class TestRedisPipeline {


    public static void main(String[] args) {
//        Jedis jedis = new Jedis("172.18.152.189", 6379);
//        Long start = System.currentTimeMillis();
//        for (int i = 0; i < 10000; i++) {
//            jedis.hset("aaaa" + i, "aaaa" + i, "aaaa" + i);
//        }
//        Long end = System.currentTimeMillis();
//        System.out.println(end - start);
//        jedis.close();

        Jedis jedis = new Jedis("172.18.152.189", 6379);
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            //管道，减少链接次数
            Pipeline pipeline = jedis.pipelined();
            for (int j = i * 100; j < (i + 1) * 100; j++) {
                pipeline.hset("bbbb" + j, "bbbb" + j, "bbbb" + j);
            }
            pipeline.syncAndReturnAll();
        }
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
        jedis.close();
    }
}
