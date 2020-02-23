package com.dalingjia.pattern.singlePattern;

/**
 * 饿汉式
 *      优点:线程安全,允许多个线程同时访问
 *      缺点:会提前初始化单例对象(在类加载的时候)
 */
public class SingalDemo01 {

    private static SingalDemo01 singalDemo01 = new SingalDemo01();

    private SingalDemo01() {
    }

    public static SingalDemo01 getInstance() {
        return singalDemo01;
    }
}