package com.dalingjia.leetcode.array;

public class FindNumber {

    public static int find(int[] arr){
        int n = arr.length;
        int result = 0;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[arr[i]]++;
        }
        for (int i = 0; i < n; i++) {
            if(temp[i] >1){
                return i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1,0,2,5,3};
        System.out.println(find(arr));
    }
}
