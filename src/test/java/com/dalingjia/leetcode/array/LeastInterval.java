package com.dalingjia.leetcode.array;

import java.util.Arrays;

/**
 * @author tanhq
 * @Description 621 任务调度器
 * @Date 2019/10/1 下午8:35
 * @Version 1.0
 **/
public class LeastInterval {


    /**
     *
     * @param tasks
     * @param n
     * @return
     */
    public static int leastInterval(char[] tasks, int n) {
        int[] c = new int[26];
        for (char t : tasks) {
            c[t - 'A']++;
        }
        //排序
        Arrays.sort(c);
        int i = 25;

        while (i >= 0 && c[i] == c[25]) {
            i--;
        }
        //避免 n = 0
        //ABEF ABEG ABFG A
        //CEA CE CE
        //我们根据最长的字符，将字符串分成c[25]-1 块，每块的长度为n+1, 最后加上的字母个数为出现次数最多的任务，可能有多个并列
        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
    }

    public static void main(String[] args) {
        char[] chars = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(leastInterval(chars, 0));
    }
}

 
    
    
    
    