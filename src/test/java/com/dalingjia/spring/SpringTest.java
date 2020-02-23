package com.dalingjia.spring;

import com.dalingjia.spring.dao.UserDao;

public class SpringTest {

    public static void main(String[] args) {

        ClassPathXmlAppliactionContext classPathXmlAppliactionContext = new ClassPathXmlAppliactionContext();

        UserDao userDao = (UserDao) classPathXmlAppliactionContext.getBean("userDao");

        System.out.println(userDao);
    }
}
