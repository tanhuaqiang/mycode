package com.dalingjia.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceTest {

    private static Logger LOGGER = LoggerFactory.getLogger(ScheduledExecutorServiceTest.class);

    private static ScheduledThreadPoolExecutor threadPoolExecutor = new ScheduledThreadPoolExecutor(20);

    public static void main(String[] args) {

        Runnable runnable =  () -> System.out.println("hhhh");
        Runnable runnable1 =  () -> System.out.println("jjjj");

        /*//创建并执行在给定延迟后启用的一次性操作
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
//        service.scheduleAtFixedRate(runnable, 3, 1, TimeUnit.SECONDS);

        long delay = 3000;
        long delay1 = 10;
        //创建并执行在给定延迟后启用的一次性操作
        service.schedule(runnable, delay, TimeUnit.MILLISECONDS);//毫秒
        service.schedule(runnable1, delay1, TimeUnit.SECONDS);//秒*/
        System.out.println(new Date());
        threadScheduled();
    }

    public static void threadScheduled(){

        threadPoolExecutor.schedule(() -> {
            try {
                String afterContent = new Date()+"✨好东西当然要分享，发送图片给爱熬夜的好友，喊ta来领取补贴吧！";
                System.out.println(afterContent);
            } catch (Exception e) {
                LOGGER.error("新用户1分钟后发送客服消息 exception:{}", e);
            }
        }, 1, TimeUnit.MINUTES);
    }
}
