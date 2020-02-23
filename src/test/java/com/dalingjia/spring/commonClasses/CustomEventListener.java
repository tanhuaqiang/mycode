package com.dalingjia.spring.commonClasses;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * 自定义事件监听器
 *  需要新建一个类实现ApplicationListener接口
 */
public class CustomEventListener implements ApplicationListener {


    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if(applicationEvent instanceof AnimalEvent){
            AnimalEvent animalEvent = (AnimalEvent) applicationEvent;
            System.out.println("触发自定义事件：Animal name is " + animalEvent.getName());
        }
    }
}