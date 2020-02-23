package com.dalingjia.thead.threadCommunication.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test {

    public static void main(String[] args) {

        BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);
        Producer producer = new Producer("生产者->", bq);
        Consumer cousumer = new Consumer("消费者<-", bq);
        producer.start();
        cousumer.start();
    }
}
