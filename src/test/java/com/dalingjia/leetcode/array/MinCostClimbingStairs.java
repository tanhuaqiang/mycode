package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description 746 使用最小花费爬楼梯
 * @Date 2019/9/16 下午9:29
 * @Version 1.0
 **/
public class MinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        //dp0和dp1代表着前两层的实际消耗
        int dp0 = 0, dp1 = 0, dp2 = 0;
        for (int i = 2; i <= n; i++) {
            dp2 = Math.min(dp0 + cost[i - 2], dp1 + cost[i - 1]);
            dp0 = dp1;
            dp1 = dp2;
        }
        return dp2;
    }


    public static void main(String[] args) {
        int[] ints = {10, 15, 20};
        minCostClimbingStairs(ints);

        int[] ints2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        minCostClimbingStairs(ints2);

    }
}

 
    
    
    
    