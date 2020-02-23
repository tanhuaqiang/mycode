package com.daling.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 当一个类需要获取ApplicationContext实例时，可以让该类实现ApplicationContextAware接口
 * 当bean需要获取自身在容器中的id/name时，可以实现BeanNameAware接口
 * 继承了ApplicationContextAware接口的类，在加载spring配置文件时，会自动调用接口中的setApplicationContext方法，并可自动获得ApplicationContext对象，前提是在spring配置文件中指定了这个类
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

    public void run(){
        System.out.println(beanName);

        //发布自定义事件：要发布自定义事件，需要调用ApplicationContext的publishEvent方法
        AnimalEvent animalEvent = new AnimalEvent(this, "tiger");
        applicationContext.publishEvent(animalEvent);
    }
}