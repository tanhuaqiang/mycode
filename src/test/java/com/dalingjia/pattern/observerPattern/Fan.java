package com.dalingjia.pattern.observerPattern;

/**
 * @author tanhq
 * @Description 第一步：定义抽象观察者（Observer）：抽象的粉丝
 * @Date 2019/11/24 上午12:12
 * @Version 1.0
 **/
public interface Fan {

    public void update(String message);
}
