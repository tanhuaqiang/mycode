package com.dalingjia.leetcode.string;

/**
 * @author tanhq
 * @Description  压缩字符串
 * @Date 2019/8/23 下午6:25
 * @Version 1.0
 **/
public class Compress {

    public static int compress(char[] chars) {
        int n = chars.length;
        int cur = 0; // 当前处理字符的索引，最后是压缩串的长度
        for (int i = 0; i < n; ) {
            int j = i;
            // 找相同字符的连续个数
            while (j < n - 1 && chars[j] == chars[j + 1]) {
                j++;
            }
            // 记录当前字符
            chars[cur++] = chars[i];
            if (i != j) {
                // 当前字符的连续重复次数
                String times = (j - i + 1) + "";
                int tLen = times.length();
                //将字符的重复次数写入原串中，用以压缩字符串
                for (int k = 0; k < tLen; k++) {
                    chars[cur++] = times.charAt(k);
                }
            }
            i = j + 1;
        }
        return cur;
    }

    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c','c','c','d','d'};
        System.out.println(compress(chars));
    }

}

 
    
    
    
    