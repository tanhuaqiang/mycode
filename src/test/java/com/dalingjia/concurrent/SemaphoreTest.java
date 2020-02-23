package com.dalingjia.concurrent;

import java.util.concurrent.Semaphore;

/**
 * Semaphore其实和锁有点类似，它一般用于控制对某组资源的访问权限
 */
public class SemaphoreTest {
    
    public static void main(String[] args) {
        int N = 8;            //工人数
        // 创建具有给定的许可数和非公平的公平设置的 Semaphore
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < N; i++) {
            new Worker(i, semaphore).start();
        }
    }

    static class Worker extends Thread {
        private int num;
        private Semaphore semaphore;

        public Worker(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人" + this.num + "占用一个机器在生产...");
                Thread.sleep(2000);
                System.out.println("工人" + this.num + "释放出机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}