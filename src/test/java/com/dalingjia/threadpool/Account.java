package com.dalingjia.threadpool;

public class Account {
    /**
     * 定义一个ThreadLocal类型的变量，该变量将是一个线程局部变量，
     * 每个线程都会保留该变量的一个副本
     */
    private static ThreadLocal<String> name = new ThreadLocal<String>();

    public Account(String str) {
        name.set(str);
        //当前线程的name的副本的值
        System.out.println("----" + name.get());
    }

    public String getName() {
        return name.get();
    }

    public void setName(String str) {
        name.set(str);
    }

}
