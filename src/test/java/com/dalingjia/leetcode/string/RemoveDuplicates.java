package com.dalingjia.leetcode.string;

/**
 * @author tanhq
 * @Description 1047 删除字符串中的所有相邻重复项
 * @Date 2019/9/19 下午10:32
 * @Version 1.0
 **/
public class RemoveDuplicates {

    public String removeDuplicates(String S) {

        int n = S.length();
        int i = 0;
        char[] c = new char[n];
        for (int j = 0; j < n; j++) {
            if (i > 0 && c[i - 1] == S.charAt(j)) {
                i--;
            } else {
                c[i++] = S.charAt(j);
            }
        }
        return new String(c, 0, i);
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abdfasfs");
        System.out.println(sb.delete(1, 3));
    }
}

 
    
    
    
    