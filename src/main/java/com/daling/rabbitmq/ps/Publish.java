package com.daling.rabbitmq.ps;

import com.daling.util.rabbitmq.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Publish {


    private final static String EXCHANGE_NAME = "test_exchange_fanout";

    public static void main(String[] args) {

        Connection connection = null;
        Channel channel = null;

        try {
            connection = ConnectionUtil.getConnection();
            channel = connection.createChannel();

            //声明exchange
            //交换机没有存储的能力，如果没有队列和交换机绑定，那么消息发送到交换机，消息将会消失
            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

            String message = "hello world!";
            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
            System.out.println("publish " + message);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(channel != null){
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
