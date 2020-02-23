package com.dalingjia.leetcode.number;

public class InversionNumber {

    public static int inversion(int[] arr){
        if(arr == null){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i] > arr[i+1]){
                count++;
            }
        }

        System.out.println("count=" + count);
        return count%1000000007;
    }

    public static void main(String[] args) {

        int[] arr = {3,5,2,4,9,1};
        System.out.println(inversion(arr));
    }
}
