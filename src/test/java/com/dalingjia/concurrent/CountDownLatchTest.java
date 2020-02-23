package com.dalingjia.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch和CyclicBarrier都能够实现线程之间的等待，只不过它们侧重点不同：
 * 1、CountDownLatch 一般用于某个线程A等待若干个其他线程执行完任务之后，它才执行；
 * 2、CyclicBarrier  一般用于一组线程互相等待至某个状态，然后这一组线程再同时执行；
 * 另外，CountDownLatch是不能够重用的，而CyclicBarrier是可以重用的。
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        /**
         *  一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
         *  构造一个用给定计数初始化的 CountDownLatch
         */
        final CountDownLatch latch = new CountDownLatch(2);
        new Thread(){
            public void run() {
                try {
                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(6000);
                    System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                    // 递减锁存器的计数，如果计数到达零，则释放所有等待的线程
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

        new Thread(){
            public void run() {
                try {
                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(2000);
                    System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                    // 递减锁存器的计数，如果计数到达零，则释放所有等待的线程
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

        try {
            System.out.println("等待2个子线程执行完毕...");
            // 使当前线程在 锁存器 倒计数为0之前一直等待，除非线程被中断。
            latch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
