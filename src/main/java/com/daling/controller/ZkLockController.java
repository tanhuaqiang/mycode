package com.daling.controller;

import com.daling.util.lock.LockUtils;
import com.daling.util.lock.redisTemplateLock.RedisLock;
import com.daling.util.lock.zkLock.ZkLock;
import com.daling.util.lock.zkLock.ZookeeperLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("/zookeeper")
public class ZkLockController {


    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void checkJedisLock(String mobile) {
        // 先获取锁，同一个手机号串行操作
        // ZkLock实现了AutoCloseable，try代码块结束后会执行close方法
        try(ZkLock zkLock = LockUtils.getZLock(mobile)){
            if (!zkLock.tryLock()) {
                System.out.println("获取zk锁过于频繁");
                //返回
                return;
            }else {
                System.out.println("获取zk锁成功！！！！");
            }
            //停留3秒代表处理业务处理逻辑
            Thread.sleep(1000);
            System.out.println("atomicInteger = " + atomicInteger.incrementAndGet());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * http://localhost:8080/zookeeper/testLock
     */
    @RequestMapping("/testLock")
    public void testLock() {
        System.out.println("jlfjsljfs");
        //启动10个线程模拟资源竞争
        for (int i = 0; i < 1; i++) {
            new Thread(() -> checkJedisLock("18336549989")).start();
        }

    }
}
