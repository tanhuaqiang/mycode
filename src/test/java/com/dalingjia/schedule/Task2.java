package com.dalingjia.schedule;

import java.util.Timer;
import java.util.TimerTask;

public class Task2 {
    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // task to run goes here
                System.out.println("Hello !!!");
            }
        };

        /**
         * 1,Timer类可以调度任务，TimerTask则是通过在run()方法里实现具体任务。 Timer实例可以调度多任务，它是线程安全的
         * 2,当Timer的构造器被调用时，它创建了一个线程，这个线程可以用来调度任务
         */
        Timer timer = new Timer();
        long delay = 0;
        long intevalPeriod = 1 * 1000;
        timer.scheduleAtFixedRate(task, delay, intevalPeriod);//安排指定的任务在指定的延迟后开始进行重复的固定速率执行
        System.out.println("hhhhh");//hhhh和定时任务会同时执行（delay为0）
        //timer.schedule(task, delay);//安排在指定延迟后, 执行指定的任务
    }
}
