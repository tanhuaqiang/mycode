package com.dalingjia.leetcode.string;

import java.util.*;

/**
 * @author tanhq
 * @Description  796 旋转字符串
 * @Date 2019/9/17 下午3:48
 * @Version 1.0
 **/
public class RotateString {

    public static boolean rotateString(String A, String B) {
        if (A == null || B == null) {
            return false;
        }
        //都为""的情况
        if (A.length() < 1 && B.length() < 1) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        //找到所有与B.charAt(0)相同的字符的位置
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == B.charAt(0)) {
                list.add(i);
            }
        }
        //字符字符串
        if (list.size() < 1) {
            return false;
        }
        //遍历所有的位置，然后反转字符串A
        for (int i = 0; i < list.size(); i++) {
            String pre = A.substring(0, list.get(i));
            String next = A.substring(list.get(i));
            if (B.equals(next + pre)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        rotateString("bbbacddceeb", "ceebbbbacdd");
    }
}

 
    
    
    
    