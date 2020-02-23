package com.dalingjia.leetcode.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class CountdownLatchTest {

    public static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ExecutorService service = Executors.newCachedThreadPool();
        final CountDownLatch cdAnswer = new CountDownLatch(3);
        Runnable runnable1 = new Runnable() {
            public void run() {
                try {
                    for (int i = 3; i <= 1000000; i += 3) {
                        boolean mark = true;
                        for (int j = 2; j <= Math.sqrt(i); j++) {
                            if (i % j == 0) {
                                mark = false;
                                break;
                            }
                        }
                        if (mark) {
                            atomicInteger.getAndIncrement();
                        }
                    }
                    cdAnswer.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable runnable2 = new Runnable() {
            public void run() {
                try {
                    for (int i = 2; i <= 1000000; i += 3) {
                        boolean mark = true;
                        for (int j = 2; j <= Math.sqrt(i); j++) {
                            if (i % j == 0) {
                                mark = false;
                                break;
                            }
                        }
                        if (mark) {
                            atomicInteger.getAndIncrement();
                        }
                    }
                    cdAnswer.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable runnable3 = new Runnable() {
            public void run() {
                try {
                    for (int i = 4; i <= 1000000; i += 3) {
                        boolean mark = true;
                        for (int j = 2; j <= Math.sqrt(i); j++) {
                            if (i % j == 0) {
                                mark = false;
                                break;
                            }
                        }
                        if (mark) {
                            atomicInteger.getAndIncrement();
                        }
                    }
                    cdAnswer.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        service.execute(runnable1);
        service.execute(runnable2);
        service.execute(runnable3);
        try {
            cdAnswer.await();
            // 78498个
            System.out.println("1000000以内求得的素数个数是：" + atomicInteger.get());
            long end = System.currentTimeMillis();
            System.out.println("并行计算所用时间：" + (end - start) + "毫秒");
        } catch (Exception e) {
            e.printStackTrace();
        }
        service.shutdown();



    }


    /**
     * 判断素数
     * @param s
     * @return
     */
    private static boolean primeNumber(int s) {
        for (int i = 2; i <= Math.sqrt(s); i++) {
            if(s % i == 0){
                return false;
            }
        }
        return true;
    }
}