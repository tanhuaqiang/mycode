package com.daling.dao;

import com.daling.bean.User;

import java.util.List;

/**
 * @author tanhq
 * @Description TODO
 * @Date 2019/12/5 下午7:28
 * @Version 1.0
 **/
public interface UserMapper {

    /***
     * 某个用户的所有订单
     * ***/
    User loadUsersOrders(Integer uid);

    List<User> loadAllUserOrders();
}
