package com.dalingjia.threadpool;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExcutorTest {

    private static ScheduledThreadPoolExecutor stpe = null;

    private static int index = 0;

    private static String getTime(){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }

    public static void main(String[] args) {
        System.out.println(getTime());
        //构造一个ScheduledThreadPoolExecutor对象，并且设置它的容量为5个
        stpe = new ScheduledThreadPoolExecutor(5);
        //隔3秒后开始执行任务，随后，在每一次执行终止后，隔1秒开始下一次执行
//        stpe.scheduleWithFixedDelay(() -> {
//            index++;
//            System.out.println(getTime() + "\t" + index);
//            try {
//                //验证执行终止后，隔一秒开始下一次执行
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            if (index >= 10){
//                //启动线程池的关闭序列
//                stpe.shutdown();
//                if (stpe.isShutdown()){
//                    System.out.println("停止了！！！");
//                }
//            }
//        } ,3, 1, TimeUnit.SECONDS);

        //2秒后开始执行，并以1秒的频率重复执行
        stpe.scheduleAtFixedRate(() -> {
            index++;
            System.out.println(getTime() + "*********" + index);
            try {
                //如果此任务的任何一个执行要花费比其周期更长的时间，则将 推迟后续执行，但不会同时执行；所以下次执行要等3秒
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (index >= 10){
                stpe.shutdown();
                if (stpe.isShutdown()){
                    System.out.println("停止了！！！");
                }
            }
        }, 2, 1, TimeUnit.SECONDS);

        //隔2秒后执行一次，但只会执行一次；此时线程池不会关闭
        stpe.schedule(() -> {
            index++;
            System.out.println(getTime() + "*********" + index);
            if (index >= 10){
                stpe.shutdown();
                if (stpe.isShutdown()){
                    System.out.println("停止了！！！");
                }
            }
        }, 2, TimeUnit.SECONDS);
    }
}