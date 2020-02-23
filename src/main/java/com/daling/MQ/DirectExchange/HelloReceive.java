package com.daling.MQ.DirectExchange;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *
 * 接收端：
 * 我们需要配置监听器去监听绑定到的消息队列,当消息队列有消息的时候,予以接收
 * 通过@RabbitListener注解定义该类对hello队列的监听
 * 通过@RabbitHandler注解来指定对消息的处理方法
 */
//@Component
//@RabbitListener(queues="queue")
//public class HelloReceive {
//
//    //指定对消息的处理方法不能少
//    @RabbitHandler
//    public void processC(String str) {
//        System.out.println("===================Receive:"+str);
//    }
//
//}