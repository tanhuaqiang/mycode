package com.dalingjia.pattern.observerPattern;

import java.util.*;

/**
 * @author tanhq
 * @Description 第四步：具体主题（ConcreteSubject）：具体的明星
 * @Date 2019/11/24 上午12:17
 * @Version 1.0
 **/
public class ConcreateIdol implements Idol {

    /**
     * 保存每一位粉丝
     */
    private List<Fan> list = new ArrayList<>();

    @Override
    public void addFan(Fan fan) {
        list.add(fan);
    }

    @Override
    public void delFan(Fan fan) {
        list.remove(fan);
    }

    /**
     * 通知每一位粉丝消息
     * @param message
     */
    @Override
    public void notify(String message) {
        for (Fan fan : list) {
            fan.update(message);
        }
    }
}

 
    
    
    
    