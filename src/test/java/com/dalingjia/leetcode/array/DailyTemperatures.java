package com.dalingjia.leetcode.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author tanhq
 * @Description 739 每日温度
 * @Date 2019/10/1 上午6:53
 * @Version 1.0
 **/
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        for (int i = 0; i < T.length - 1; i++) {
            boolean flag = false;
            for (int j = i + 1; j < T.length; j++) {
                if (T[i] < T[j]) {
                    T[i] = j - i;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                T[i] = 0;
            }
        }
        T[T.length - 1] = 0;
        return T;
    }

    public int[] dailyTemperatures2(int[] T) {
        Stack<Integer> stack = new Stack<Integer>();
        int size = T.length;
        int[] res = new int[size];
        Arrays.fill(res, 0);
        for (int i = 0; i < size; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int t = stack.pop();
                res[t] = i - t;
            }
            stack.push(i);
        }
        return res;
    }

}

 
    
    
    
    