package com.dalingjia.blockQueue;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {

    //是否在运行标志,并不能保证线程安全
    private volatile boolean isRunning = true;

    private static final Integer SLEEP_TIME = 1000;

    //必须是静态的变量，保证全局只有一份
    private static AtomicInteger count = new AtomicInteger();

    private BlockingDeque queue;

    public Producer(BlockingDeque queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        String data = "";
        Random rand = new Random();

        try {
            while (isRunning){

                Thread.sleep(rand.nextInt(SLEEP_TIME));
                //以原子方式将count当前值加1
                data = "data:" + count.incrementAndGet();
                System.out.println("将数据：" + data + "放入队列。。。");
                //设定的等待时间为3s，如果超过3s还没加进去返回false
                if(!queue.offer(data, 3, TimeUnit.SECONDS)){
                    System.out.println("放入数据失败：" + data);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            System.out.println("退出生产者线程~~~");
        }
    }

    public void stop(){
        isRunning = false;
    }

}
