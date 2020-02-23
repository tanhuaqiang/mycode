package com.dalingjia.leetcode.number;

import java.util.Arrays;

/**
 * @author tanhq
 * @Description 1033 移动石子直到连续
 * @Date 2019/9/19 下午9:31
 * @Version 1.0
 **/
public class NumMovesStones {

    public int[] numMovesStones(int a, int b, int c) {
        int[] res = new int[2];
        int[] stone = new int[]{a, b, c};
        Arrays.sort(stone);
        res[1] = stone[2] - stone[0] - 2;

        if (stone[0] == stone[1] - 1 && stone[1] == stone[2] - 1) {
            res[0] = 0;
        } else if (stone[1] - stone[0] <= 2 || stone[2] - stone[1] <= 2) {
            res[0] = 1;
        } else {
            res[0] = 2;
        }
        return res;
    }
}

 
    
    
    
    