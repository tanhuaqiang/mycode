package com.dalingjia.thead;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    /**
     *
     *  实现原理：在CyclicBarrier的内部定义了一个Lock对象，每当一个线程调用await方法时，将拦截的线程数减1，然后判断剩余拦截数是否为初始值parties，
     *  如果不是，进入Lock对象的条件队列等待。如果是，执行barrierAction对象的Runnable方法，然后将锁的条件队列中的所有线程放入锁等待队列中，这些线程会依次的获取锁、释放锁
     *
     *  CyclicBarrier 支持一个可选的 Runnable 命令，在一组线程中的最后一个线程到达之后（但在释放所有线程之前），
     *  该命令只在每个屏障点运行一次。若在继续所有参与线程之前更新共享状态，此屏障操作 很有用。
     */
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Apple());

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(1);
        }).start();

        new Thread(() -> {
            try {
                cyclicBarrier.await();
                System.out.println(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println("parties = " + cyclicBarrier.getParties());
        System.out.println("getNumberWaiting = " + cyclicBarrier.getNumberWaiting());

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(2);

    }

    private static class Apple implements Runnable{

        @Override
        public void run() {
            System.out.println("I am a apple!");
        }
    }
}
