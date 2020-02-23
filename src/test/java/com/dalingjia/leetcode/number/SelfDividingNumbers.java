package com.dalingjia.leetcode.number;

import java.util.*;

/**
 * @author tanhq
 * @Description 728 自除数
 * @Date 2019/9/16 下午9:11
 * @Version 1.0
 **/
public class SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDivid(i)) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean isSelfDivid(int i) {
        int temp = i;
        while (i > 0) {

            int yushu = i % 10;
            if (yushu == 0 || temp % yushu != 0) {
                return false;
            }
            i /= 10;
        }
        return true;
    }
}

 
    
    
    
    