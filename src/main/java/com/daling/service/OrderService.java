package com.daling.service;

import java.util.List;
import com.daling.bean.Orders;

/**
 * @author tanhq
 * @Description TODO
 * @Date 2019/12/5 下午5:55
 * @Version 1.0
 **/
public interface OrderService {

    /***
     * 加载某个订单关联的用户
     * ***/
    List<Orders> loadOrdersUsers(Integer oid);

}
