package com.dalingjia.pattern.observerPattern;

/**
 * @author tanhq
 * @Description 第二步：具体的观察者（concreteObserver）：具体的粉丝
 * @Date 2019/11/24 上午12:13
 * @Version 1.0
 **/
public class ConcreateFan implements Fan {

    private String fanName;

    public ConcreateFan(String fanName) {
        this.fanName = fanName;
    }

    @Override
    public void update(String message) {
        System.out.println(fanName + "知道了：" + message + "这条消息！");
    }
}

 
    
    
    
    