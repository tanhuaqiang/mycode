package com.daling.MQ.fanoutExchange;

import com.daling.SpringbootApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes=SpringbootApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestRabbitMQ {
    
    @Autowired
    private FanoutExchangeHelloSender helloSender;

    @Test
    public void testRabbit() {
        helloSender.send();
    }

    @Test
    public void sendObject() {
        helloSender.sendObject();
    }

}