package com.dalingjia.thead.producerComsumer;

public class Comsumer implements Runnable {

    private String name;
    private Storage storage;

    public Comsumer(String name, Storage storage) {
        this.name = name;
        this.storage = storage;
    }

    @Override
    public synchronized void run() {
        try{
            while (true){
                Product product = storage.pop();
                System.out.println(name + "消费一个" + product.toString());
                Thread.sleep(1000);

            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
