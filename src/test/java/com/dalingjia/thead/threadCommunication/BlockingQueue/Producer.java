package com.dalingjia.thead.threadCommunication.BlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {

    private BlockingQueue<String> bq;

    /**
     * @param name 线程名称
     * @param bq
     */
    public Producer(String name, BlockingQueue<String> bq) {
        super(name);
        this.bq = bq;
    }

    @Override
    public void run() {
        String[] strings = {"Java", "Spring", "Mysql"};
        for (int i = 0; i < 10; i++) {
            try {
                bq.put(strings[i%3]);
                System.out.println(getName() + "生成：" + bq);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
