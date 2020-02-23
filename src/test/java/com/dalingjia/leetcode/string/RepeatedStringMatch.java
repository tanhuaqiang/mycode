package com.dalingjia.leetcode.string;

/**
 * @author tanhq
 * @Description  686 重复叠加字符串匹配
 * @Date 2019/9/9 下午4:40
 * @Version 1.0
 **/
public class RepeatedStringMatch {

    public int repeatedStringMatch(String A, String B) {
        int count = 0;
        StringBuilder str = new StringBuilder();
        while (str.length() < B.length()) {
            str.append(A);
            count++;
        }
        if (str.toString().contains(B)) {
            return count;
        }
        if (str.append(A).toString().contains(B)) {
            return ++count;
        }
        return -1;
    }
}

 
    
    
    
    