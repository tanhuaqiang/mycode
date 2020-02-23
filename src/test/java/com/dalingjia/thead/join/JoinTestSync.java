package com.dalingjia.thead.join;

public class JoinTestSync {

    public static void main(String[] args) throws InterruptedException {
        ThreadJoinTest1 t1 = new ThreadJoinTest1("T1");
        ThreadJoinTest1 t2 = new ThreadJoinTest1("T2");
        ThreadJoinTest1 t3 = new ThreadJoinTest1("T3");
        /**
         * 通过join方法来确保t1、t2、t3的执行顺序
         */
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
    }
}

class ThreadJoinTest1 extends Thread {

    public ThreadJoinTest1(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName() + ":" + i);
        }
    }
}