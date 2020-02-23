package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description Nim游戏
 * @Date 2019/8/21 下午3:56
 * @Version 1.0
 **/
public class CanWinNim {

    public boolean canWinNim(int n) {
        //题目中给的数字4很关键，余下4块石头的话，先取石头的人无论如何都赢不了
        return n % 4 != 0;
    }
}

 
    
    
    
    