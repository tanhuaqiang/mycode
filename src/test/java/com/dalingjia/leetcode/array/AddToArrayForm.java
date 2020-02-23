package com.dalingjia.leetcode.array;

import java.util.*;

/**
 * @author tanhq
 * @Description  989 数组形式的整数加法
 * @Date 2019/9/19 下午12:25
 * @Version 1.0
 **/
public class AddToArrayForm {

    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> list = new ArrayList<>();
        //使用栈
        Deque<Integer> res = new ArrayDeque();
        //使用队列
        Deque<Integer> queue = new ArrayDeque();
        while (K > 0) {
            int yushu = K % 10;
            queue.offer(yushu);
            K /= 10;
        }
        //A , K , 进位
        int[] ints = {0, 0, 0};
        int index = A.length -1;
        while (true) {
            int a = 0;
            int b = 0;
            if (index < 0) {
                ints[0] = 1;
            }else {
                a = A[index--];
            }
            if (queue.size() > 0) {
                b = queue.poll();
            }else {
                ints[1] = 1;
            }
            if (ints[0] > 0 && ints[1] > 0) {
                if (ints[2] == 1) {
                    res.push(1);
                }
                break;
            }else {
                int sum = a + b + ints[2];
                if (sum > 9) {
                    ints[2] = 1;
                    res.push(sum - 10);
                }else {
                    ints[2] = 0;
                    res.push(sum);
                }
            }
        }
        for (Integer i : res) {
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] A = {1,2,0,0};
        int K = 34;
        addToArrayForm(A, K);
    }
}

 
    
    
    
    