package com.dalingjia.thead.producerComsumer;

public class Producer implements Runnable{

    private String name;
    private Storage storage;

    public Producer(String name, Storage storage) {
        this.name = name;
        this.storage = storage;
    }

    @Override
    public synchronized void run() {
        try{
            while (true) {
                Product product = new Product((int) (Math.random() * 10000));
                storage.push(product);
                System.out.println(name + "生成一个：" + product.toString());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
