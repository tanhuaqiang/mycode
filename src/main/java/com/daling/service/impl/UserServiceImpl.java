package com.daling.service.impl;

import com.daling.bean.User;
import com.daling.dao.UserMapper;
import com.daling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tanhq
 * @Description TODO
 * @Date 2019/12/5 下午7:27
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User loadUsersOrders(Integer uid) {
        return userMapper.loadUsersOrders(uid);
    }

    @Override
    public List<User> loadAllUserOrders() {
        return userMapper.loadAllUserOrders();
    }
}

 
    
    
    
    