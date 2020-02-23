package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description  leetcode 9 回文数
 * @Date 2019/10/19 下午4:10
 * @Version 1.0
 **/
public class IsPalindrome {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String num = String.valueOf(x);
        int i = 0;
        int j = num.length()-1;
        while (i < j) {
            if (num.charAt(i) == num.charAt(j)) {
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }
}

 
    
    
    
    