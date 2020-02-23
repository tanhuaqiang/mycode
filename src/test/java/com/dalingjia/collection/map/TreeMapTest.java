package com.dalingjia.collection.map;


import java.util.*;

/**
 * @author tanhq
 * @Description TreeMap
 * @Date 2019/10/16 下午4:31
 * @Version 1.0
 **/
public class TreeMapTest {

    public static void main(String[] args) {
        //TreeMap的输出是排好序的
        TreeMap<String, String> map = new TreeMap<>();
        map.put("d", "ddd");
        map.put("a", "aaa");
        map.put("e", "eee");
        map.put("c", "ccc");
        map.put("b", "bbb");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "---" + entry.getValue());
        }

    }
}

 
    
    
    
    