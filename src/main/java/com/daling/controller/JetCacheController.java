package com.daling.controller;

import com.daling.cache.GatewayCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController = @Controller + @ResponseBody
 */
@RestController
@RequestMapping(path = "/jetcache")
public class JetCacheController {

    private Logger logger = LoggerFactory.getLogger(JetCacheController.class);


    @Autowired
    private GatewayCache gatewayCache;


    @RequestMapping(value="/getStudent")
    public void get(){
        for (int i = 0; i < 10 ; i++) {
            new Thread(() -> gatewayCache.getStudent()).start();
        }
    }

}
