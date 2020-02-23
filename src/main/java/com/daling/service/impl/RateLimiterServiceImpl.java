package com.daling.service.impl;

import com.daling.service.RateLimiterService;
import com.google.common.util.concurrent.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RateLimiterServiceImpl implements RateLimiterService {

    private Logger log = LoggerFactory.getLogger(RateLimiterServiceImpl.class);

    /**
     * 每秒不超过10个请求
     */
    public static final RateLimiter limiter = RateLimiter.create(10);


    @Override
    public boolean flowCrtl() {
        if (limiter.tryAcquire()){
            return true;
        }else{
            return false;
        }
    }

//    public static void main(String[] args) {
//        RateLimiterServiceImpl rateLimiterService = new RateLimiterServiceImpl();
//        for (int i = 0; i < 20; i++) {
//            Runnable runnable = ()->{
//                System.out.println(rateLimiterService.flowCrtl());;
//            };
//            new Thread(runnable).start();
//        }
//    }
}
