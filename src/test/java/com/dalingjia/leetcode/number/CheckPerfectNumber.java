package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description  507 完美数
 * @Date 2019/9/5 下午9:08
 * @Version 1.0
 **/
public class CheckPerfectNumber {

    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }
        if (num == sum) {
            return true;
        }
        return false;
    }
}

 
    
    
    
    