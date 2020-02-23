package com.daling.MQ.topicExchange;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class TopicExchangeReceive {

    @RabbitListener(queues="topic.message")    //监听器监听指定的Queue
    public void process1(String str) {
        System.out.println("message:"+str);
    }


    @RabbitListener(queues="topic.messages")    //监听器监听指定的Queue
    public void process2(String str) {
        System.out.println("messages:"+str);
    }
}
