package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description  1122 数组的相对排序
 * @Date 2019/9/21 下午5:51
 * @Version 1.0
 **/
public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr2.length == 0) {
            return arr1;
        }
        //定义个长度为1001的数组，
        int[] temp = new int[1001];
        int[] res = new int[arr1.length];
        //统计每个数字出现的次数
        for (int i : arr1) {
            temp[i]++;
        }
        int index = 0;
        for (int i : arr2) {
            //i出现的次数
            int t = temp[i];
            while (t > 0) {
                res[index++] = i;
                t--;
            }
            temp[i] = 0;
        }

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != 0) {
                int t = temp[i];
                while (t > 0) {
                    res[index++] = i;
                    t--;
                }
            }
        }
        return res;
    }
}

 
    
    
    
    