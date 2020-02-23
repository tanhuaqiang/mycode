package com.dalingjia.thead;

import java.util.concurrent.atomic.AtomicInteger;
 
public class AtomicIntegerTest {
 
    private static final int THREADS_CONUT = 5;
    public static AtomicInteger count = new AtomicInteger(0);
 
    public static void increase() {
        //获取当前的值，并加上预期的值,这也是个原子操作
        count.getAndAdd(5);
    }
 
    public static void main(String[] args) {

        Thread[] threads = new Thread[THREADS_CONUT];
        for (int i = 0; i < THREADS_CONUT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        //返回当前线程的线程组中活动线程的数目
//        while (Thread.activeCount() > 1) {
//            //暂停当前正在执行的线程对象，并执行其他线程
//            Thread.yield();
//        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}