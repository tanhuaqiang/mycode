package com.dalingjia.pattern.observerPattern;

/**
 * @author tanhq
 * @Description 测试
 * @Date 2019/11/24 上午12:20
 * @Version 1.0
 **/
public class Test {

    public static void main(String[] args) {
        //1,有一个明星
        Idol idol = new ConcreateIdol();
        //2，有3个粉丝
        Fan fan1 = new ConcreateFan("tanhq");
        Fan fan2 = new ConcreateFan("xiaoming");
        Fan fan3 = new ConcreateFan("jingling");
        //3，粉丝关注明星
        idol.addFan(fan1);
        idol.addFan(fan2);
        idol.addFan(fan3);
        //4，明星发布动态，粉丝接受动态
        idol.notify("我会唱，跳，rap，打篮球，music！！！");
    }
}

 
    
    
    
    