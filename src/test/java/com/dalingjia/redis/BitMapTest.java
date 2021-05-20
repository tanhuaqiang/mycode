package com.dalingjia.redis;

import com.daling.util.lock.jedisLock.RedisHelper;
import redis.clients.jedis.Jedis;

import java.util.BitSet;

/**
 * @author tanhq
 * @Description TODO
 * @Date 2019/11/13 下午11:48
 * @Version 1.0
 **/
public class BitMapTest {

    public static void main(String[] args) {
        Jedis j = RedisHelper.getJedis();

//        j.auth("myredis");

        j.setbit("login:2016-12-3".getBytes(), 1, true);
        j.setbit("login:2016-12-3".getBytes(), 124431, true);
        j.setbit("login:2016-12-3".getBytes(), 1231, true);
        j.setbit("login:2016-12-3".getBytes(), 323121, true);
        BitSet b = BitSet.valueOf(j.get("login:2016-12-3".getBytes()));

//the number of bit value 1
        int lognum3 = b.cardinality();
        System.out.println("2016-12-3  login user number: " + lognum3);


//2016-12-3  login operation user
        j.setbit("login:2016-12-4".getBytes(), 1, true);
        j.setbit("login:2016-12-4".getBytes(), 1231231, true);
        j.setbit("login:2016-12-4".getBytes(), 334441, true);
        BitSet b2 = BitSet.valueOf(j.get("login:2016-12-4".getBytes()));

        int lognum4 = b2.cardinality();
        System.out.println("2016-12-4  login user number: " + b2.cardinality());

        b.or(b2);
//or操作之后 同样userid的记录会重合不做记录，所以具体的数据统计看自己的需求而定
        int lognumexceptsameuser = b.cardinality();
        int logtotalnum = lognum3 + lognum4;
        System.out.println("2016-12-3 to 2016-12-4 login user number except same userid: " + lognumexceptsameuser);
        System.out.println("2016-12-3 to 2016-12-4 login user number: " + logtotalnum);


        System.out.println("login:2016-12-4".getBytes() + "===========");
    }


}

 
    
    
    
    