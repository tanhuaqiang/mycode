package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description  1176 健身计划评估
 * @Date 2019/9/22 下午10:35
 * @Version 1.0
 **/
public class DietPlanPerformance {

    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int point = 0;
        for (int i = 0; i < calories.length-k+1; i++) {
            int calor = 0;
            int t = 0;
            while (t < k) {
                calor += calories[i + t];
                t++;
            }
            if (calor < lower) {
                point--;
            }
            if (calor > upper) {
                point++;
            }
        }
        return point;
    }
}

 
    
    
    
    