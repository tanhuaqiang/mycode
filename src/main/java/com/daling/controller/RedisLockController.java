package com.daling.controller;

import com.daling.util.lock.redisTemplateLock.RedisLock;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("/redis")
public class RedisLockController {


    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void checkJedisLock(String mobile) {
        // 先获取锁，同一个手机号串行操作
        // RedisLock实现了Closeable接口，try代码块结束后会执行close方法
        try(RedisLock redisLock = new RedisLock(redisTemplate, mobile)){
            boolean lock = redisLock.lock();
            if (!lock) {
                System.out.println("获取锁过于频繁");
                //返回
                return;
            }else {
                System.out.println("获取锁成功！！！！");
            }
            //停留3秒代表处理业务处理逻辑
            Thread.sleep(3000);
            System.out.println("atomicInteger = " + atomicInteger.incrementAndGet());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * http://localhost:8080/redis/testLock
     */
    @RequestMapping("/testLock")
    public void testLock() {
        System.out.println("jlfjsljfs");
        //启动10个线程模拟资源竞争
        for (int i = 0; i < 10; i++) {
            new Thread(() -> checkJedisLock("18336549989")).start();
        }

    }
}
