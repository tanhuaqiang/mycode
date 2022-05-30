package com.dalingjia.leetcode.array;

public class MergeArray {

    /**
     * 88,合并两个有序数组
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     */
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-- + --n;

        while (n >= 0) {
            nums1[i--] = (m >= 0 && nums1[m] > nums2[n]) ? nums1[m--] : nums2[n--];
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        int[] arr = merge(nums1, m, nums2, n);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }





    }

}
