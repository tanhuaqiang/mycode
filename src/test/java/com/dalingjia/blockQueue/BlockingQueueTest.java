package com.dalingjia.blockQueue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingQueueTest {

    public static void main(String[] args) {
        //声明一个容量为10的阻塞队列
        BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>(10);

        //生产者，消费者
        Producer producer1 = new Producer(blockingDeque);
        Producer producer2 = new Producer(blockingDeque);
        Producer producer3 = new Producer(blockingDeque);

        Consumer consumer = new Consumer(blockingDeque);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(producer1);
        executorService.submit(producer2);
        executorService.submit(producer3);
        executorService.submit(consumer);

        try {
            //执行10s
            Thread.sleep(1000*3);

            //停止生产
            producer1.stop();
            producer2.stop();
            producer3.stop();

            //等待消费者消费
//            Thread.sleep(20* 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
