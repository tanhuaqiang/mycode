package com.dalingjia.leetcode.string;

/**
 * @author tanhq
 * @Description  521 最长特殊序列I
 * @Date 2019/9/5 下午9:52
 * @Version 1.0
 **/
public class FindLUSlength {

    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }

}

 
    
    
    
    