package com.dalingjia.thead;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ControlThreadExecutionSequenceTest {

    static Thread thread1 = new Thread(()->{
        for (int i = 0; i < 10; i++) {
            System.out.println("T1-" + i);
        }
    });

    static Thread thread2 = new Thread(()->{
        for (int i = 0; i < 10; i++) {
            System.out.println("T2-------" + i);
        }
    });

    static Thread thread3 = new Thread(()->{
        for (int i = 0; i < 10; i++) {
            System.out.println("T3----------------" + i);
        }
    });

    /**
     * 如何控制多线程的执行顺序
     * @param args
     */
    public static void main(String[] args) {
//        try {
//            thread1.start();
//            //main线程必须等待join线程执行完毕
//            thread1.join();
//            thread2.start();
//            //main线程必须等待join线程执行完毕
//            thread2.join();
//            thread3.start();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //创建只有一个线程的线程池，底层是无界阻塞队列: LinkedBlockingQueue
        ExecutorService executor = Executors.newFixedThreadPool(1);
//        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(thread1);
        executor.submit(thread2);
        executor.submit(thread3);
        executor.shutdown();
    }
}
