package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description 1010 总持续时间可被60整除的歌曲
 * @Date 2019/9/19 下午4:50
 * @Version 1.0
 **/
public class NumPairsDivisibleBy60 {

    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        for (int i = 0; i < time.length; ++i) {
            int index = time[i] % 60;
            ++count[index];
        }
        int pair = 0;
        for (int i = 1; i < 30; ++i) {
            //和为60的做乘法
            pair += count[i] * count[60 - i];
        }
        //取一个值，再从剩下的取一个值
        pair += count[0] * (count[0] - 1) / 2;
        pair += count[30] * (count[30] - 1) / 2;
        return pair;

    }
}

 
    
    
    
    