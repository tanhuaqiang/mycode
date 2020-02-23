package com.daling.controller.mybatis;

import com.daling.bean.Orders;
import com.daling.controller.BaseController;
import com.daling.service.OrderService;
import com.daling.util.common.JsonHeaderWrapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

/**
 * @author tanhq
 * @Description TODO
 * @Date 2019/12/5 下午5:53
 * @Version 1.0
 **/
@RestController
@RequestMapping("order")
public class OrderController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private OrderService orderService;


    @RequestMapping(value = "loadOrdersUsers.do", method = RequestMethod.POST)
    public JsonHeaderWrapper loadOrdersUsers(Orders orders, HttpServletResponse response, HttpServletRequest request) {
        JsonHeaderWrapper result = new JsonHeaderWrapper<>();
        String trackId = StringUtils.isBlank(request.getParameter("trackId")) ? UUID.randomUUID().toString() : request.getParameter("trackId");
        result.setTrack_id(trackId);
        result.setStatus(JsonHeaderWrapper.StatusEnum.Success.getCode());
        result.setErrmsg(JsonHeaderWrapper.StatusEnum.Success.getDesc());
        try {
            List<Orders> list = orderService.loadOrdersUsers(orders.getOid());
            result.setData(list);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.setStatus(JsonHeaderWrapper.StatusEnum.UnknownOther.getCode());
            result.setErrmsg(JsonHeaderWrapper.StatusEnum.UnknownOther.getDesc());
        } finally {
            result.timeWatchStop();
        }
        return result;
    }


}

 
    
    
    
    