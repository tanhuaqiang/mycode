package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description  1184 公交站间的距离
 * @Date 2019/9/22 下午10:47
 * @Version 1.0
 **/
public class DistanceBetweenBusStops {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum = 0;
        for (int i : distance) {
            sum += i;
        }
        //比较出大小值，然后顺时针走
        int min = Math.min(start, destination);
        int max = Math.max(start, destination);
        //顺时针走
        int one = 0;
        for (int i = min; i < max; i++) {
            one += distance[i];
        }
        //逆时针走
        int two = sum - one;
        //比较大小
        return Math.min(one, two);
    }
}

 
    
    
    
    