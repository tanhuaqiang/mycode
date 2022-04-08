package com.dalingjia.thead;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 两个线程交替打印奇数和偶数
 */
public class PrintOddEven {


    private static Lock lock = new ReentrantLock();
    private static int state = 1;

    /**
     * 打印奇数
     */
    static class PrintOdd extends Thread {

        @Override
        public void run() {
            for (int i = 1; i <= 100; ) {
                lock.lock();
                if (state % 2 == 1) {
                    System.out.println("奇数：" + i);
                    state++;
                    i += 2;
                }
                lock.unlock();
            }
        }
    }

    /**
     * 打印偶数
     */
    static class PrintEven extends Thread {

        @Override
        public void run() {
            for (int i = 2; i <= 100; ) {
                lock.lock();
                if (state % 2 == 0) {
                    System.out.println("偶数：" + i);
                    state++;
                    i += 2;
                }
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        new PrintOdd().start();
        new PrintEven().start();
    }
}
