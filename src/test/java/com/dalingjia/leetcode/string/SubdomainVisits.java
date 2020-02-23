package com.dalingjia.leetcode.string;

import afu.org.checkerframework.checker.igj.qual.I;

import java.util.*;

/**
 * @author tanhq
 * @Description 811 子域名访问计数
 * @Date 2019/9/17 下午4:43
 * @Version 1.0
 **/
public class SubdomainVisits {

    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String s : cpdomains) {
            String[] strings = s.split("\\s+");
            String domain = strings[1];
            Integer times = Integer.parseInt(strings[0]);
            int len = domain.split("\\.").length;
            //有2个.
            if (len == 3) {
                map.put(domain.substring(domain.indexOf(".") + 1), map.getOrDefault(domain.substring(domain.indexOf(".") + 1),0) + times);
            }
            map.put(domain, map.getOrDefault(domain,0) + times);
            map.put(domain.substring(domain.lastIndexOf(".") + 1), map.getOrDefault(domain.substring(domain.lastIndexOf(".") + 1),0) + times);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry.getValue() + " " + entry.getKey());
        }

        return list;
    }


    public static void main(String[] args) {
        String[] strings = "ff.jlfs.efafaf".split("\\.");
        System.out.println(strings);
    }
}

 
    
    
    
    