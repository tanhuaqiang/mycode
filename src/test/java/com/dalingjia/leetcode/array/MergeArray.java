package com.dalingjia.leetcode.array;

public class MergeArray {

    /**
     * 合并两个有序数组
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     */
    private static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums2.length; i++) {
            nums1[m++] = nums2[i];
        }
        
        for (int i = nums1.length-nums2.length; i < nums1.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums1[i] < nums1[j]){
                    int temp = nums1[j];
                    nums1[j] = nums1[i];
                    nums1[i] = temp;
                }
            }
        }
        return nums1;
    }


    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;

        int[] arr = merge(nums1, m, nums2, n);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

}
