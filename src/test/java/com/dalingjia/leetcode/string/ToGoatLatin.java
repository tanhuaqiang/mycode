package com.dalingjia.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanhq
 * @Description 824 山羊拉丁文
 * @Date 2019/9/17 下午6:17
 * @Version 1.0
 **/
public class ToGoatLatin {

    public String toGoatLatin(String S) {
        String[] str = S.split("\\s+");
        String result = "";
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('A');
        list.add('e');
        list.add('E');
        list.add('i');
        list.add('I');
        list.add('o');
        list.add('O');
        list.add('u');
        list.add('U');
        for (int i = 0; i < str.length; i++) {
            if (list.contains(str[i].charAt(0))) {
                result += (str[i] +"ma");
            }else {
                result += (str[i].substring(1) + str[i].substring(0, 1) + "ma");
            }
            StringBuilder sb = new StringBuilder("");
            for (int j = 0; j <= i; j++) {
                sb.append("a");
            }
            result += (sb.toString()+" ");

        }

        return result.trim();
    }

}

 
    
    
    
    