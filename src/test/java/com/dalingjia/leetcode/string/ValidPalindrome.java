package com.dalingjia.leetcode.string;

/**
 * @author tanhq
 * @Description  leetcode 680 验证回文字符串
 * @Date 2019/9/8 下午10:14
 * @Version 1.0
 **/
public class ValidPalindrome {

    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            }else {
                return isPalindrome(s, i + 1, j) || isPalindrome(s,i,j-1);
            }
        }

        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}

 
    
    
    
    