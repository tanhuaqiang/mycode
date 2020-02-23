package com.dalingjia.leetcode.string;

/**
 * @author tanhq
 * @Description  917 仅仅反转字母
 * @Date 2019/9/18 下午3:05
 * @Version 1.0
 **/
public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int i = 0;
        int j = chars.length - 1;

        while (i < j) {
            while (!Character.isLetter(chars[i]) && i < j) {
                i++;
            }
            while (!Character.isLetter(chars[j]) && i < j) {
                j--;
            }
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(chars);

    }
}

 
    
    
    
    