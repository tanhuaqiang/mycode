package com.dalingjia.redis.jedis;

import com.daling.util.lock.LockUtils;
import com.daling.util.lock.jedisLock.RdLock;

import java.util.concurrent.atomic.AtomicInteger;

public class JedisLockTest {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void checkJedisLock(String mobile) {
        // 先获取锁，同一个手机号串行操作
        // RdLock实现了Closeable接口，try代码块结束后会执行close方法
        try(RdLock rdLock = LockUtils.getRLock(mobile)){
            boolean lock = rdLock.tryLock();
            if (!lock) {
                System.out.println("获取锁过于频繁");
                //返回
                return;
            }else {
                System.out.println("获取锁成功！！！！");
            }
            //停留一秒代表处理业务处理逻辑
            Thread.sleep(1000);
            System.out.println("atomicInteger = " + atomicInteger.incrementAndGet());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        //启动10个线程模拟资源精致
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> checkJedisLock("18336549989")).start();
        }

    }
}
