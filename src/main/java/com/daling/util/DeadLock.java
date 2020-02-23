package com.daling.util;

/**
 * @author tanhq
 * @Description TODO
 * @Date 2019/11/9 下午10:49
 * @Version 1.0
 **/
public class DeadLock {

    private static final String A = "A";
    private static final String B = "B";

    public static void deadLock(){
        Thread thread1 = new Thread(() -> {
            synchronized (A){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B){
                    System.out.println("1");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (B){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (A){
                    System.out.println("2");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}

 
    
    
    
    