package com.dalingjia.spring.test;

import com.dalingjia.spring.cyclicDependency.Appconfig;
import com.dalingjia.spring.cyclicDependency.X;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author tanhq
 * @Description TODO
 * @Date 2019/12/4 下午11:41
 * @Version 1.0
 **/
public class CyclicDependencyTest {

    public static void main(String[] args) {
        //实例化一个ApplicationContext对象
        ApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);

        System.out.println(ac.getBean(X.class) + "*************************");
    }

}

 
    
    
    
    