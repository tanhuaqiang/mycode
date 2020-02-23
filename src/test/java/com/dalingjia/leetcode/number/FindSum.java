package com.dalingjia.leetcode.number;

import com.google.common.collect.Maps;

import java.util.Map;

public class FindSum {

    public static Map<Integer, Integer> findSum(int[] arr, int sum){
        Map<Integer, Integer> map = Maps.newHashMap();
        if(arr == null || arr.length <=1){
            throw new IllegalArgumentException("数组长度异常");
        }
        int start =0;
        int end = arr.length-1;
        while (start < end){
            if(arr[start] + arr[end] >sum){
                end--;
            }else if(arr[start] + arr[end] < sum){
                start++;
            }else {
                map.put(arr[start], arr[end]);
                start++;
                end--;
            }
        }
        return map;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 7, 8, 10, 11};
        System.out.println(findSum(arr, 8));
    }
}
