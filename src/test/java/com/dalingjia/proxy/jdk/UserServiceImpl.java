package com.dalingjia.proxy.jdk;

/**
 * 被代理的类
 * JDK的动态代理有一个限制，就是被动态代理的对象必须实现一个或多个接口
 */
public class UserServiceImpl implements UserService {

    @Override
    public String hello(String name) {
        System.out.println("hello " + name);
        return name;
    }

}
