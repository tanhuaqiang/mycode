package com.dalingjia.leetcode.string;

/**
 * @author tanhq
 * @Description  944 删列造序
 * @Date 2019/9/18 下午9:38
 * @Version 1.0
 **/
public class MinDeletionSize {

    public int minDeletionSize(String[] A) {
        int count = 0;
        int len = A.length; //数组个数
        int l = A[0].length(); //字符串的长度
        for (int x = 0; x < l; x++) {
            for (int y = 0; y < len - 1; y++) {
                if (A[y].charAt(x) > A[y + 1].charAt(x)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }


}

 
    
    
    
    