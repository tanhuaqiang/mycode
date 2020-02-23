package com.daling.MQ.fanoutExchange;

import com.daling.bean.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 发送端代码
 * 在SpringBoot中,我们使用AmqpTemplate去发送消息!
 * @Component:（把普通pojo实例化到spring容器中，相当于配置文件中的 <bean id="" class=""/>）
 * 交换机是rabbitmq默认的
 */
@Component
public class FanoutExchangeHelloSender {

    @Autowired
    private AmqpTemplate template;

    //queue为指定的key
    public void send() {
        String message = "hello,fanoutExchange  rabbitmq!";
        //第一个参数是routingKey
        //当发送者发送消息的时候,指定对应的Key.当Key和消息队列的BindingKey一致的时候,消息将会被发送到该消息队列中.
        System.out.println("***************sender message:" + message);
        //广播模式，即使指定了key，也会被忽略
        //参数：交换机，路由key，对象
        template.convertAndSend("fanoutExchange", "",  message);
    }

    //发送对象
    public void sendObject(){
        User user = new User(100, "tanhq", new Date());
        template.convertAndSend("queue", user);

    }


}