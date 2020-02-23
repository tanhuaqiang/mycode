package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description  717    1比特与2比特字符
 * @Date 2019/9/15 下午7:33
 * @Version 1.0
 **/
public class IsOneBitCharacter {

    public boolean isOneBitCharacter(int[] bits) {
        for (int i = 0; i < bits.length; ) {
            if (bits[i] == 1) {
                i += 2;
            }else {
                if (i == bits.length - 1) {
                    return true;
                }else {
                    i++;
                }
            }
        }
        return false;
    }
}

 
    
    
    
    