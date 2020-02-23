package com.daling.controller.mybatis;

import com.daling.bean.User;
import com.daling.controller.BaseController;
import com.daling.service.UserService;
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
 * @Description
 * @Date 2019/12/5 下午7:26
 * @Version 1.0
 **/
@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private UserService userService;


    @RequestMapping(value = "loadUserOrders.do", method = RequestMethod.POST)
    public JsonHeaderWrapper loadUserOrders(User user, HttpServletResponse response, HttpServletRequest request) {
        JsonHeaderWrapper result = new JsonHeaderWrapper<>();
        String trackId = StringUtils.isBlank(request.getParameter("trackId")) ? UUID.randomUUID().toString() : request.getParameter("trackId");
        result.setTrack_id(trackId);
        result.setStatus(JsonHeaderWrapper.StatusEnum.Success.getCode());
        result.setErrmsg(JsonHeaderWrapper.StatusEnum.Success.getDesc());
        try {
            User userOrders = userService.loadUsersOrders(user.getId());
            result.setData(userOrders);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setStatus(JsonHeaderWrapper.StatusEnum.UnknownOther.getCode());
            result.setErrmsg(JsonHeaderWrapper.StatusEnum.UnknownOther.getDesc());
        } finally {
            result.timeWatchStop();
        }
        return result;
    }

    @RequestMapping(value = "loadAllUserOrders.do", method = RequestMethod.POST)
    public JsonHeaderWrapper loadAllUserOrders(HttpServletResponse response, HttpServletRequest request) {
        JsonHeaderWrapper result = new JsonHeaderWrapper<>();
        String trackId = StringUtils.isBlank(request.getParameter("trackId")) ? UUID.randomUUID().toString() : request.getParameter("trackId");
        result.setTrack_id(trackId);
        result.setStatus(JsonHeaderWrapper.StatusEnum.Success.getCode());
        result.setErrmsg(JsonHeaderWrapper.StatusEnum.Success.getDesc());
        try {
            List<User> userOrders = userService.loadAllUserOrders();
            result.setData(userOrders);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.setStatus(JsonHeaderWrapper.StatusEnum.UnknownOther.getCode());
            result.setErrmsg(JsonHeaderWrapper.StatusEnum.UnknownOther.getDesc());
        } finally {
            result.timeWatchStop();
        }
        return result;
    }

}

 
    
    
    
    