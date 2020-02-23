package com.dalingjia.leetcode.string;

import java.util.Arrays;

/**
 * @author tanhq
 * @Description 1170 比较字符串最小字母出现频次
 * @Date 2019/9/22 下午5:24
 * @Version 1.0
 **/
public class NumSmallerByFrequency {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] res = new int[queries.length];
        //1，queries数组中字符串的最小字母出现频次
        int[] q = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            q[i] = f(queries[i]);
        }
        //2，words数组中字符串的最小字母出现频次
        int[] w = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            w[i] = f(words[i]);
        }
        //3,排序
        Arrays.sort(w);
        for (int i = 0; i < q.length; i++) {
            int t = 0;
            //4，满足条件的数目
            while (t < w.length && q[i] >= w[t]) {
                t++;
            }
            res[i] = w.length - t;
        }
        return res;
    }

    /**
     * 统计字符串中最小字母出现频次
     * @param query
     * @return
     */
    private int f(String query) {
        int n = 0;
        int[] res = new int[26];
        char[] chars = query.toCharArray();
        for (char c : chars) {
            res[c - 'a']++;
        }
        for (int i : res) {
            if (i > 0) {
                return i;
            }
        }
        return n;
    }


}

 
    
    
    
    