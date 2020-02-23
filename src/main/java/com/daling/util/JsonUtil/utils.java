package com.daling.util.JsonUtil;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class utils {

    public static String toErrorJson(String num, String info, String detail) {
        Map<String, String> error = new HashMap<String, String>();
        error.put("status", num);
        error.put("errorMsg", info);
        error.put("error_detail", detail);
        return JSON.toJSONString(error);
    }

    public static void main(String[] args) {
        String returnJson = toErrorJson("500", "参数错误", "参数错误");
        System.out.println(returnJson);

        System.out.println("add".equalsIgnoreCase("ADD"));
    }
}
