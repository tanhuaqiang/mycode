package com.dalingjia.spring.dao.impl;

import com.dalingjia.spring.bean.User;
import com.dalingjia.spring.dao.UserDao;

public class UserDaoImpl implements UserDao {

    @Override
    public void add(User user) {
        System.out.println("a user add!");
    }
}
