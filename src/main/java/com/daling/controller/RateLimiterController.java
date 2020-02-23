package com.daling.controller;

import com.daling.service.RateLimiterService;
import com.daling.util.common.JsonHeaderWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping(path = "/http")
public class RateLimiterController {
    private Logger log = LoggerFactory.getLogger(RateLimiterController.class);

    @Autowired
    private RateLimiterService rateLimiterService;

    @RequestMapping(value = "selectDeliveryList.do")
    public JsonHeaderWrapper<Map<String, Object>> selectDeliveryList(HttpServletRequest request) {
        JsonHeaderWrapper<Map<String, Object>> result = new JsonHeaderWrapper<>();
        try {
            //限流
            boolean flowFlag = rateLimiterService.flowCrtl();
            if(!flowFlag){
                result.setStatus(JsonHeaderWrapper.StatusEnum.OverFlowCtrl.getCode());
                result.setErrmsg(JsonHeaderWrapper.StatusEnum.OverFlowCtrl.getDesc());
                return result;
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
        }
        return result;
    }
}
