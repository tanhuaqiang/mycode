package com.dalingjia.leetcode.array;

import java.util.Arrays;

/**
 * @author tanhq
 * @Description 914 卡牌分组
 * @Date 2019/9/18 下午1:29
 * @Version 1.0
 **/
public class HasGroupsSizeX {

    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length < 2) {
            return false;
        }
        //1，排序
        Arrays.sort(deck);

        int len = deck.length;
        //2,X可能的取值
        for (int x = 2; x <= len; x++) {
            //3，x必须被整除
            if (len % x == 0 && dfs(deck, x)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int[] deck, int x) {

        //4，判断每组的牌数必须相同
        for (int i = 0; i < deck.length; i += x) {
            int t = 1;
            //也可以用set来判断
            while (t < x) {
                if (deck[i] != deck[i + t]) {
                    return false;
                }
                t++;
            }
        }
        return true;
    }
}

 
    
    
    
    