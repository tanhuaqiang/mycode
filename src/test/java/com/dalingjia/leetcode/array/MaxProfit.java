package com.dalingjia.leetcode.array;

import org.junit.Test;

/**
 * 买卖股票的最佳时机
 */
public class MaxProfit {
    //只买卖一次
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 0){
            return 0;
        }
        int min = prices[0];//数组中的最小值
        int maxProfit = 0; //最大利润
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }else {
                int profit = prices[i] - min;
                if(profit >= maxProfit){
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    //买卖多次，获取最大利润
    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length < 1){
            return 0;
        }
        int pre = prices[0];//买入的值
        int sum = 0; //最大利润
        for (int i = 1; i < prices.length; i++) {
            int now = prices[i];
            //如果当前值大于买入的值，就卖掉
            if(now > pre){
                sum += now - pre;
            }
            pre = now;
        }
        return sum;
    }

    @Test
    public void test(){
        int[] ints = {};
        maxProfit(ints);
    }
}
