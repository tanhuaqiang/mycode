package com.dalingjia.thead.producerComsumer;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 仓库，使用阻塞队列存放产品
 */
public class Storage {

    BlockingDeque<Product> queues = new LinkedBlockingDeque<>(1);

    //生成产品
    public void push(Product product){
        try {
            queues.put(product);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //消费产品
    public Product pop() throws InterruptedException {
        return queues.take();
    }

}
