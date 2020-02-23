package com.dalingjia.leetcode.string;

/**
 * @author tanhq
 * @Description  942 增减字符串匹配
 * @Date 2019/9/18 下午9:13
 * @Version 1.0
 **/
public class DiStringMatch {

    public int[] diStringMatch(String S) {
        int[] res = new int[S.length() + 1];
        //定义2个指针
        int start = 0;
        int end = S.length();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'I') {
                res[i] = start;
                start++;
            }else {
                res[i] = end;
                end--;
            }
        }
        res[S.length()] = start;
        return res;
    }
}

 
    
    
    
    