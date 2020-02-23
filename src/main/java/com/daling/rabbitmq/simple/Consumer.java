package com.daling.rabbitmq.simple;

import com.daling.util.rabbitmq.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {

    public static void main(String[] args) {
        Connection connection = null;
        Channel channel = null;
        boolean flag = true;

        try {
            //1,获取连接以及mq通道
            connection = ConnectionUtil.getConnection();

            //2，从连接中创建通道
            channel = connection.createChannel();

            //3,声明（创建）队列,对于队列，最好创建一个
            channel.queueDeclare(ConnectionUtil.QUEUE_NAME, false, false, false, null);

            //4,定义队列的消费者
            QueueingConsumer consumer = new QueueingConsumer(channel);

            //5,监听消息，手动返回完成状态   true:自动确认 ，false:手动确认
            channel.basicConsume(ConnectionUtil.QUEUE_NAME, true, consumer);

            while(flag){
                QueueingConsumer.Delivery delivery = consumer.nextDelivery();
                String message = new String(delivery.getBody());
                System.out.println("consumer message=" + message);
//                if(message != null){
//                    flag = false;
//                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(channel != null){
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
