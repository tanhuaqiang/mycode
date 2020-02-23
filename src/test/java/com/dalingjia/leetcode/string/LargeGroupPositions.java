package com.dalingjia.leetcode.string;

import java.util.*;

/**
 * @author tanhq
 * @Description 830 较大分组的位置
 * @Date 2019/9/17 下午6:34
 * @Version 1.0
 **/
public class LargeGroupPositions {

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> list = new ArrayList<>();
        int start = 0;
        int end = 0;
        char t = S.charAt(0);
        int len = S.length();
        int i = 1;
        while (i < len) {
            if (t == S.charAt(i)) {
                end++;
                //创建list对象的时机为该字符是连续的最后一个字符
                if (end - start >= 2 && (i + 1 >= len || t != S.charAt(i + 1))) {
                    List<Integer> list1 = new ArrayList<>(2);
                    list1.add(start);
                    list1.add(end);
                    list.add(list1);
                }
            }else {
                t = S.charAt(i);
                start = i;
                end = i;
            }
            i++;
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(2);
        System.out.println(list1);
    }
}

 
    
    
    
    