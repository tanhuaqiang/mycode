package com.daling.rabbitmq.work;

import com.daling.util.rabbitmq.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {

    private final static String QUEUE_NAME = "test_queue_work";

    public static void main(String[] args) {

        Connection connection = null;
        Channel channel = null;

        try {
            //1,获取连接以及mq通道
            connection = ConnectionUtil.getConnection();

            //2，从连接中创建通道
            channel = connection.createChannel();

            //3,声明（创建）队列
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            //4,消息内容
            for (int i = 0; i < 50; i++) {
                String message = "" + i;
                channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
                System.out.println("Producer message: " + message );
                Thread.sleep(i + i);
            }



//            System.out.println("Producer message: '" + message +"'");

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
