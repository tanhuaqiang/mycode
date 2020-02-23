package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description 693 交替位二进制数
 * @Date 2019/9/9 下午5:40
 * @Version 1.0
 **/
public class HasAlternatingBits {

    public boolean hasAlternatingBits(int n) {

        int i = n & 1;
        while (n > 0) {
            i++;
            i = i % 2;
            n = n >> 1;
            if (i != (n & 1)) {
                return false;
            }
        }
        return true;
    }
}

 
    
    
    
    