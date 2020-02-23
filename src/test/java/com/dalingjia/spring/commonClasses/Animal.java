package com.dalingjia.spring.commonClasses;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 当一个类需要获取ApplicationContext实例时，可以让该类实现ApplicationContextAware接口
 * 当bean需要获取自身在容器中的id/name时，可以实现BeanNameAware接口
 */
public class Animal implements ApplicationContextAware, BeanNameAware {

    private String beanName;
    private ApplicationContext applicationContext;

    @Override
    public void setBeanName(String s) {
        beanName = s;
    }

    /**
     *
     * @param applicationContext  该参数将由Spring容器自动赋值
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        applicationContext = applicationContext;
    }

    @Test
    public void run(){
        System.out.println(beanName);

        //发布自定义事件
        AnimalEvent animalEvent = new AnimalEvent(this, "tiger");
        applicationContext.publishEvent(animalEvent);
    }
}