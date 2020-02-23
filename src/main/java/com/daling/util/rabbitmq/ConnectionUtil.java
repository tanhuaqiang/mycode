package com.daling.util.rabbitmq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConnectionUtil {

    public final static String QUEUE_NAME = "rabbitmq";

    public static Connection getConnection() throws Exception {

        //1,定义链接工厂
        ConnectionFactory factory = new ConnectionFactory();

        //2,设置服务地址
        factory.setHost("localhost");

        //3,协议端口：5672
        factory.setPort(5672);

        //4,设置账号信息：用户名，密码，vhost
        factory.setVirtualHost("/tanhq");
        factory.setUsername("tanhq");
        factory.setPassword("thq!789123");

        //5,通过工程获取连接
        Connection connection = factory.newConnection();
        return connection;
    }

}
