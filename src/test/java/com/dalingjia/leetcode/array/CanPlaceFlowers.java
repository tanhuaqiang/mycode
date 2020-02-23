package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description 605 种花问题
 * @Date 2019/9/7 下午6:10
 * @Version 1.0
 **/
public class CanPlaceFlowers {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if ((flowerbed[i] == 0) && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }

            if (count >= n){
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[] ints = {1, 0, 0, 0, 0, 1};
        int n = 2;
        canPlaceFlowers(ints, n);
    }
}

 
    
    
    
    