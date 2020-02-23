package com.dalingjia.spring.aop;

import org.springframework.context.annotation.*;

/**
 * 当我们需要强制使用CGLIB来实现AOP的时候，需要配置spring.aop.proxy-target-class=true
 * 或@EnableAspectJAutoProxy(proxyTargetClass = true)
 */
@Configuration
@ComponentScan(basePackages = "com.dalingjia.spring")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class TestConfiguration {

    public TestConfiguration() {
        System.out.println("spring容器启动初始化。。。。。。。。。。。。。。。。。");
    }
}


//@Bean注解注册bean,同时可以指定初始化和销毁方法
//    @Bean(name="testBean",initMethod="start",destroyMethod="cleanUp")
////    @Bean
//    @Scope("prototype")
//    public TestBean testBean() {
//        return new TestBean();
//    }