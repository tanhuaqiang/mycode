package com.daling.MQ.DirectExchange;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注意由于采用的是Direct模式(精确匹配key),需要在配置Queue的时候,指定一个键,使其和交换机绑定.
 */
//@Configuration
//public class SenderConf {
//
//
//     //配置Queue(消息队列),queue为队列的key值
//     //创建消息队列的时候,指定一个BindingKey:queue
//     @Bean
//     public Queue queue() {
//          return new Queue("direct.queue");
//     }
//}