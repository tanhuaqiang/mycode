package com.dalingjia.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanhq
 * @Description  1078 Bigram分词
 * @Date 2019/9/20 下午9:25
 * @Version 1.0
 **/
public class FindOcurrences {

    public String[] findOcurrences(String text, String first, String second) {
        List<String> answer = new ArrayList<String>();
        String[] str = text.split("\\s+");
        for (int i = 0; i < str.length -2; i++) {
            if (str[i].equals(first) && str[i+1].equals(second)) {
                answer.add(str[i + 2]);
            }
        }

        return answer.toArray(new String[answer.size()]);
    }

    public static void main(String[] args) {
        System.out.println("a".split("\\s+")[0]);
    }
}

 
    
    
    
    