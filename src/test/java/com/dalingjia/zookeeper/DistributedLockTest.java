package com.dalingjia.zookeeper;

import com.daling.zookeeper.DistributedLock;

public class DistributedLockTest {

    public static int n = 500;

    public static void secskill() {
        System.out.println(--n);
    }

    public static void main(String[] args) {
        Runnable runnable =() -> {
                DistributedLock lock = null;
                try {
                    //1,链接zookeeper，创建根节点
                    lock = new DistributedLock("127.0.0.1:2181", "test1");
                    //2,获取分布式锁
                    lock.lock();
                    //3,执行业务流程
                    secskill();
//                    System.out.println(Thread.currentThread().getName() + "正在运行");
                } finally {
                    if (lock != null) {
                        lock.unlock();
                    }
                }
        };

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(runnable);
            t.start();
        }
    }

}