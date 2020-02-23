package com.dalingjia.pattern.singlePattern;

/**
 * 单例模式：双重检测锁机制
 *      线程安全并且不会提前初始化实例对象(注意两次判断检测的作用)
 */
public class SingletonPattern {

    /**
     * 定义一个私有的静态singleton变量
     * volatile: 防止指令重排序
     */
    private static volatile SingletonPattern singleton = null;

    //私有的构造方法，限制其它类直接new一个实例对象，要获取对象，必须使用下面的getInstance()方法
    private SingletonPattern() {
        System.out.println("我是无参数的构造方法！！！");
    }

    /**
     * 静态的方法，可以使用类名调用，同时也可以直接使用静态变量singleton
     * 必须使用双重锁：当a,b两个线程都执行到同步代码块这里时，a线程进入同步代码块，实例化一个Singleton()，结束代码块的执行；
     * 这时b线程进来，如果不进行判断，又实例化一个Singleton(),singleton引用指向它; 之前的对象变为垃圾，待回收，没必要
     * @return
     */
    public static SingletonPattern getInstance() {
        //第一个if是避免同步阻塞等待
        if (singleton == null) {
            synchronized (SingletonPattern.class) {
                //第二个if是为了避免产生多个对象
                if (singleton == null) {
                    singleton = new SingletonPattern();
                }
            }
        }
        return singleton;
    }
}
