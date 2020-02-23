package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description  猜数字大小
 * @Date 2019/8/22 上午10:20
 * @Version 1.0
 **/
public class GuessGame {

    public int guessNumber(int n) {
        int i = 1;
        int mid = 0;
        while (i < n) {
            mid = (n - i) / 2 + i;
            if (guess(mid) == -1) {
                n = mid -1;
            } else if (guess(mid) == 1) {
                i = mid + 1;
            } else {
                break;
            }
        }
        return mid;
    }

    private int guess(int mid) {
        return 0;
    }

}

 
    
    
    
    