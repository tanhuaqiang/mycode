package com.daling.MQ.fanoutExchange;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MQProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sender(String queueName) {

        String msg = "my_fanout_msg:" + System.currentTimeMillis();

        //请求头设置消息id（messageId）
        Message message = MessageBuilder.withBody(msg.getBytes())
                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .setContentEncoding("utf-8")
                .setMessageId(UUID.randomUUID() + "").build();

        System.out.println(msg + ":" + msg);

        amqpTemplate.convertAndSend(queueName, message);
    }
}
