package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description 丑数
 * @Date 2019/8/21 上午10:43
 * @Version 1.0
 **/
public class IsUgly {

    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        if (num % 2 == 0) {
            num = num >> 1;
            return isUgly(num);
        }
        if (num % 3 == 0) {
            num /= 3;
            return isUgly(num);
        }
        if (num % 5 == 0) {
            num /= 5;
            return isUgly(num);
        }
        return false;
    }

    public boolean isUgly2(int num) {
        if(num == 0){
            return false;
        }
        while (num % 2 == 0) {
            num = num >> 1;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1 ? true : false;
    }
}

 
    
    
    
    