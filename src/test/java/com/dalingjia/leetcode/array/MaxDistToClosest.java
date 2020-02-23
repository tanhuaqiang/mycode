package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description 849 到最近的人的最大距离
 * @Date 2019/9/17 下午7:35
 * @Version 1.0
 **/
public class MaxDistToClosest {

    /**
     * 思路：求解两个1之间的0的个数，假设0的个数为i，则距两侧最近的距离为(i+1)/2
     *
     * @param seats
     * @return
     */
    public int maxDistToClosest(int[] seats) {
        int ans = 0;
        int lens = 0;
        for (int i = 0; i < seats.length; i++) {
            lens = seats[i] == 1 ? 0 : ++lens;
            ans = Math.max(ans, (lens + 1) / 2);  //求出距离两侧最近距离
        }
        //0,0,0,0,0,1这种情况
        for (int i = 0; i < seats.length; i++) {    //当开始位置为0时
            if (seats[i] == 1) {
                ans = Math.max(ans, i);
                break;
            }
        }
        //1,0,0,0,0,0这种情况
        for (int i = seats.length - 1; i >= 0; i--) {  //当结束位置为0时
            if (seats[i] == 1) {
                ans = Math.max(ans, seats.length - 1 - i);
                break;
            }
        }
        return ans;
    }


}

 
    
    
    
    