package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description  排列硬币
 * @Date 2019/8/23 下午6:12
 * @Version 1.0
 **/
public class ArrangeCoins {

    public int arrangeCoins(int n) {
        int result = 0;
        if(n == 0){
            return result;
        }
        int index = 1;
        while (n > index) {
            n -= index;
            index++;
        }
        return n < index ? index-1 : n;
    }

}

 
    
    
    
    