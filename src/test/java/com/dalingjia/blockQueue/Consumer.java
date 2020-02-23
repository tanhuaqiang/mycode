package com.dalingjia.blockQueue;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {

    private static final Integer SLEEP_TIME = 1000;

    private BlockingDeque<String> queue;

    public Consumer(BlockingDeque queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        boolean isRunning = true;
        Random rand = new Random();

        try {
            while (isRunning) {
                //有数据时直接从队列的队首取走，无数据时阻塞；在3秒内有数据，取走，没有返回失败
                String data = queue.poll(3, TimeUnit.SECONDS);
                if(data != null){
                    System.out.println("消费者消费队列中的数据。。。" + data);
                    Thread.sleep(rand.nextInt(SLEEP_TIME));
                }else {
                    // 超过3s还没数据，认为所有生产线程都已经退出，自动退出消费线程。
                    isRunning = false;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            System.out.println("消费者退出线程。。。。");
        }
    }
}
