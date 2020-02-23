package com.dalingjia.leetcode.array;

import java.util.Arrays;

/**
 * @author tanhq
 * @Description  1037 有效的回旋镖
 * @Date 2019/9/19 下午9:55
 * @Version 1.0
 **/
public class IsBoomerang {

    public boolean isBoomerang(int[][] points) {
        double a = Math.sqrt(Math.pow((points[0][0]-points[1][0]), 2) + Math.pow((points[0][1]-points[1][1]), 2));
        double b = Math.sqrt(Math.pow((points[0][0]-points[2][0]), 2) + Math.pow((points[0][1]-points[2][1]), 2));
        double c = Math.sqrt(Math.pow((points[1][0]-points[2][0]), 2) + Math.pow((points[1][1]-points[2][1]), 2));
        double[] d = {a, b, c};
        Arrays.sort(d);
        return d[0] + d[1] > d[2];
    }
}

 
    
    
    
    