package com.dalingjia.thead.producerComsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerComsumerTest {

    public static void main(String[] args) {
        //定义一个带缓存的线程池
        ExecutorService service = Executors.newCachedThreadPool();

        //使用一个仓库
        Storage storage = new Storage();

        //定义一个生产者和一个消费者
        Producer producer = new Producer("tanhq", storage);
        Comsumer comsumer = new Comsumer("jingling", storage);

        //向线程池中提交线程
        service.submit(producer);
        service.submit(comsumer);
    }
}
