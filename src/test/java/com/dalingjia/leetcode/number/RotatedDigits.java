package com.dalingjia.leetcode.number;

import java.util.*;

/**
 * @author tanhq
 * @Description 788 旋转数字
 * @Date 2019/9/17 下午3:31
 * @Version 1.0
 **/
public class RotatedDigits {

    Map<Integer, Integer> map = new HashMap();

    public int rotatedDigits(int N) {
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 5);
        map.put(5, 2);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        int count = 0;
        for (int i = 2; i <= N; i++)
            if (method(i)) {
                count++;
            }
        return count;
    }

    private boolean method(int i) {
        int t = i; //临时值
        int ten = 1; //记录数字的位值
        int sum = 0; //旋转后的值
        while (i > 0) {
            int yushu = i % 10;
            if (map.get(yushu) == null) {
                return false;
            }
            sum += map.get(yushu) * ten;
            ten *= 10;
            i /= 10;
        }
        if (sum != t) {
            return true;
        }
        return false;
    }
}

 
    
    
    
    