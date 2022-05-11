package com.dalingjia;

/**
 * @author tanhq
 * @Description TODO
 * @Date 2022/4/21 上午11:09
 * @Version 1.0
 **/
import java.util.*;

public class Test111 {


    public static List<String> print(List<String> list) {
        Map<String, String> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (String s : list) {
            String temp = s.toLowerCase().replaceAll("[a-z]", "");
            if (!map.keySet().contains(temp)) {
                map.put(temp, s);
                result.add(s);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "123acncd";
        System.out.println(s.toLowerCase().replaceAll("[a-z]", ""));

        List<String> list = new ArrayList<>();
        list.add("123abcd");
        list.add("ancd123");
        list.add("1234bcd");
        list.add("ab1234bcd");
        List<String> print = print(list);
        System.out.println(print);
    }
}

 
    
    
    
    