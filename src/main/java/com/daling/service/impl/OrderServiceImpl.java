package com.daling.service.impl;

import com.daling.bean.Orders;
import com.daling.dao.OrderMapper;
import com.daling.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tanhq
 * @Description TODO
 * @Date 2019/12/5 下午5:56
 * @Version 1.0
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Orders> loadOrdersUsers(Integer oid) {
        return orderMapper.loadOrdersUsers(oid);
    }


}

 
    
    
    
    