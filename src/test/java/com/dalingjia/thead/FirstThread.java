package com.dalingjia.thead;


/**
 * 通过继承Thread类来创建线程类
 *
 * @author tanhq
 */
public class FirstThread extends Thread {

    private int i ;

    //run方法的方法体就是线程的执行体
    public void run() {
        for ( ; i < 10; i++) {
            System.out.println(getName() + "  " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "   " + i);
            if (i == 2) {
                //创建并启动第一个线程
                new FirstThread().start();
                //创建并启动第二个线程
                new FirstThread().start();
            }
        }
    }
}
