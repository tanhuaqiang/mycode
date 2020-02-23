package com.dalingjia.thead;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest {

//        private static volatile int count = 0;
//    private static int count = 0;
    private static AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int j = 0; j < 100; j++) {
//                        synchronized(VolatileTest.class){
//                            count++;
//                        }
                        count.incrementAndGet();
                    }
                }
            }).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
