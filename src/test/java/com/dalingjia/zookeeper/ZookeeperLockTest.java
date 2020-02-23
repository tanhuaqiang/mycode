package com.dalingjia.zookeeper;

import com.daling.util.lock.LockUtils;
import com.daling.util.lock.zkLock.ZkLock;

import java.util.concurrent.TimeUnit;

public class ZookeeperLockTest {

    private static Integer count = 10;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
//            Runnable runnable = () -> {
//                method();
//            };
//            new Thread(runnable).start();
            method();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void method(){

        try (ZkLock zkLock = LockUtils.getZLock("stunner_gold_check_" + 10000)) {
            if (!zkLock.tryLock(2, TimeUnit.SECONDS)) {
                System.out.println("网络繁忙，请稍后再试!");
            }else {
                count--;
                System.out.println("count: " + count);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
