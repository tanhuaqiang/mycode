package com.daling.dao;

import com.daling.bean.Orders;
import java.util.List;

/**
 * @author tanhq
 * @Description TODO
 * @Date 2019/12/5 下午5:58
 * @Version 1.0
 **/
public interface OrderMapper  {

    /***
     * 加载某个订单关联的用户
     * ***/
    List<Orders> loadOrdersUsers(Integer oid);
}
