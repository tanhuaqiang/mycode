package com.dalingjia.JVM;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author tanhq
 * @Description TODO
 * @Date 2019/11/5 下午10:45
 * @Version 1.0
 **/
public class JstackCase {

    public static Executor executor = Executors.newFixedThreadPool(5);
    public static Executor executor1 = Executors.newSingleThreadExecutor();
    public static Object lock = new Object();

    public static void main(String[] args) {
        Task task1 = new Task();
        Task task2 = new Task();
        executor.execute(task1);
        executor.execute(task2);

    }

    static class Task implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                calculate();
            }
        }

        public void calculate() {
            int i = 0;
            while (true) {
                i++;
                System.out.println(Thread.currentThread().getName() + "-------" + i++);
            }
        }
    }
}

 
    
    
    
    