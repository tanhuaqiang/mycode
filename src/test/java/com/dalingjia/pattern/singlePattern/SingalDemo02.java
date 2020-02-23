package com.dalingjia.pattern.singlePattern;

/**
 * 懒汉式
 *     优点:不会提前初始化单例对象
 *     缺点:线程不安全，解决方案可以通过加锁进行解决,但是加锁之后,效率低
 */
public class SingalDemo02 {
    private static SingalDemo02 singalDemo02 = null;

    private SingalDemo02() {
    }

    public static synchronized SingalDemo02 getInstance() {
        if (singalDemo02 == null) {
            singalDemo02 = new SingalDemo02();
        }
        return singalDemo02;
    }
}