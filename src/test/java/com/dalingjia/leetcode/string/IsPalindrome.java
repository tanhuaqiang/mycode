package com.dalingjia.leetcode.string;


import org.junit.Test;

/**
 * 验证回文串: 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写
 */
public class IsPalindrome {

    public boolean isPalindrome(String s) {
        char[] cha = s.toCharArray();
        int i = 0, j = cha.length - 1;
        while(i < j){
            if(!Character.isLetterOrDigit(cha[i]))
                i++;
            else if(!Character.isLetterOrDigit(cha[j]))
                j--;
            else if(Character.toLowerCase(cha[i]) == Character.toLowerCase(cha[j])){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }

    @Test
    public void method() {
        System.out.println(isPalindrome("0P"));
    }
}
