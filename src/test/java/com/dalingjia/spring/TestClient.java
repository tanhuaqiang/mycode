package com.dalingjia.spring;

import com.dalingjia.spring.aop.TestConfiguration;
import com.dalingjia.spring.service.IndexService;
import com.dalingjia.spring.service.impl.IndexServiceImpl;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestClient {


    /**
     * 1, 解析applicationgContext.xml，将xml中定义的bean(如loginService和loginResource)解析成Spring内部的BeanDefinition，
     *  并以beanName(如loginService)为key，BeanDefinition(如loginService相应的BeanDefinition)为value存储到DefaultListableBeanFactory中的beanDefinitionMap(其实就是一个ConcurrentHashMap)中，
     * 2, 同时将beanName存入beanDefinitionNames(List类型)中，然后遍历beanDefinitionNames中的beanName，进行bean的实例化并填充属性，
     *  在实例化的过程中，如果有依赖没有被实例化将先实例化其依赖，然后实例化本身，实例化完成后将实例存入单例bean的缓存中，
     *  当调用getBean方法时，到单例bean的缓存中查找，如果找到并经过转换后返回这个实例(如LoginResource的实例)，之后就可以直接使用了
     */
    @Test
    public void test() {
        //1，加载配置文件，用ClassPathXmlApplicationContext
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        System.out.println("***********************************************");

        //2,加载@Configuration注解，AnnotationConfigApplicationContext
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfiguration.class);

        IndexServiceImpl indexService = ac.getBean(IndexServiceImpl.class);

        indexService.indexService();
    }
}