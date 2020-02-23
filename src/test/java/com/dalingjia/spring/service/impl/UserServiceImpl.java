package com.dalingjia.spring.service.impl;


import com.dalingjia.spring.bean.User;
import com.dalingjia.spring.dao.UserDao;
import com.dalingjia.spring.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }
}
