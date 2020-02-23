package com.dalingjia.thead.threadCommunication.BlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread {

    private BlockingQueue bq ;

    public Consumer(String name, BlockingQueue bq) {
        super(name);
        this.bq = bq;
    }

    @Override
    public void run() {
        while (true) {
            try {
                bq.take();
                System.out.println(getName() + "消费：" + bq);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
