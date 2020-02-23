package com.dalingjia.leetcode.string;

import java.util.*;

/**
 * @author tanhq
 * @Description 859 亲密字符串
 * @Date 2019/9/17 下午9:19
 * @Version 1.0
 **/
public class BuddyStrings {

    public boolean buddyStrings(String A, String B) {
        //1, A B的长度不相等，则返回false
        if (A.length() != B.length()) {
            return false;
        }
        //2, 分两种情况，AB相等，AB不相等
        if (A.equals(B)) {
            //只要某个字符的个数大于等于2即可
            int[] ints = new int[26];
            for (char c : A.toCharArray()) {
                if (++ints[c - 'a'] >= 2) {
                    return true;
                }
            }
            return false;
        }else {
            //恰好只有2个字符不相等
            int index = -1;//记录第一个不同字符的下标
            int index2 = -1;//记录第二个不同字符的下标
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (index == -1) { //先替换掉第一个
                        index = i;
                    } else if (index2 == -1) { //再替换掉第二个
                        index2 = i;
                    }else {
                        return false; //不同字符超过2个直接返回false
                    }
                }
            }
            return A.charAt(index) == B.charAt(index2) && A.charAt(index2) == B.charAt(index);
        }
    }
}

 
    
    
    
    