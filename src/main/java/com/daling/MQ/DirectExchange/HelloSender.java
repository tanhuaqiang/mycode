package com.daling.MQ.DirectExchange;

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
public class HelloSender {

    @Autowired
    private AmqpTemplate template;

    //queue为指定的key
    public void send() {
        String message = "hello,rabbitmq! direct ";
        //第一个参数是routingKey
        //当发送者发送消息的时候,指定对应的Key.当Key和消息队列的BindingKey一致的时候,消息将会被发送到该消息队列中.
        System.out.println("***************sender message:" + message);
        template.convertAndSend("direct.queue", message);
    }

    //发送对象
    public void sendObject(){
        User user = new User(100, "tanhq", new Date());
        template.convertAndSend("direct.queue", user);

    }


}