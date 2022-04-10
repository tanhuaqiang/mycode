package com.dalingjia.test;

import com.alibaba.fastjson.JSONObject;
import com.daling.platform.util.Jackson2Helper;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

public class StringTest {

    private static void method(String s){
        s = s + "b";
    }

    public static void main(String[] args) {
        String s = "a";
        method(s);
        System.out.println(s);

        Date value = new Date();
        Timestamp lo = new Timestamp(value.getTime());
        System.out.println(lo);

        String str = "{\"version\":\"1.0\",\"timestamp\":\"180728T210728.240Z\",\"status\":0,\"errorMsg\":\"全部成功\",\"elapsed\":0,\"trackId\":null,\"data\":{\"targetedTags\":[\"老店主\"],\"bTargeted\":true}}";
        JSONObject jsonObject = JSONObject.parseObject(str);
        System.out.println(jsonObject.get("status"));
//        str.get("status").asText();
        JsonNode jsonNode = null;
        try {
            jsonNode = Jackson2Helper.parsingObject(str);
            String errorMsg = jsonNode.get("errorMsg").asText();
            System.out.println(errorMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test(){
        StringBuffer string = new StringBuffer("a,b,c,d,");
        System.out.println(string.deleteCharAt(string.length()-1));

        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());

        System.out.println("第二次提交代码，哈哈哈哈哈");
        System.out.println("2022年4月10日，提交代码ffddd");
        System.out.println("11111");
    }
}
