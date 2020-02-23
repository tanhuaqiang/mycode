package com.dalingjia.Json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Lists;

import java.util.List;

public class TypeReferenceTest {

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        list.add("a");
        list.add("b");
        list.add("c");

        JSONObject o = new JSONObject();
        o.put("k", list);

        List<String> type = o.getObject("k", List.class);
        System.out.println(JSON.toJSONString(type));

        //使用TypeReference可以明确的指定反序列化的类型
        List<String> tpye2 = o.getObject("k", new TypeReference<List<String>>(){});
        System.out.println(JSON.toJSONString(tpye2));
    }
}
