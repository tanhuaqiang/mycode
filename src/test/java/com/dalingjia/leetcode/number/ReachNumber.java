package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description  754 到达终点数字
 * @Date 2019/9/17 上午11:30
 * @Version 1.0
 **/
public class ReachNumber {

    public int reachNumber(int target) {
        target = Math.abs(target);
        int res = 0, sum = 0;
        while (sum < target || (sum - target) % 2 == 1) {
            ++res;
            sum += res;
        }
        return res;
    }
}

 
    
    
    
    