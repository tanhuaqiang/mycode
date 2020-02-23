package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description  1103 分糖果II
 * @Date 2019/9/20 下午10:24
 * @Version 1.0
 **/
public class DistributeCandies2 {

    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int i = 1;
        while (candies > 0) {
            int n = candies > i ? i : candies;
            res[(i - 1) % num_people] += n;
            i++;
            candies -= n;
        }
        return res;
    }
}

 
    
    
    
    