package com.dalingjia.spring.commonClasses;

import org.springframework.context.ApplicationEvent;

/**
 * 当需要创建自定义事件时，可以新建一个继承自ApplicationEvent抽象类的类
 */
public class AnimalEvent extends ApplicationEvent {

    private String name;

    public String getName() {
        return name;
    }

    public AnimalEvent(Object source, String name) {
        super(source);
        this.name = name;
    }

    public AnimalEvent(Object source) {
        super(source);
    }
}