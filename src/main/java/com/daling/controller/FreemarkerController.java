package com.daling.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/freemarker")
public class FreemarkerController {

    public static final Logger LOGGER = LoggerFactory.getLogger(FreemarkerController.class);

    @RequestMapping(value = "/index")
    public String index(){

        LOGGER.info("参数为：{}");
        return "index";
    }
}
