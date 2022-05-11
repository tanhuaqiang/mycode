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

    private static int[] merge2(int[] num1, int[] num2) {
        int[] result = new int[num1.length + num2.length];
        int t = 0;
        for (int i = 0; i < num1.length; i++) {
            result[t++] = num1[i];
        }
        for (int j = 0; j < num2.length; j++) {
            result[t++] = num2[j];
        }
        for (int i = result.length - num1.length; i < result.length; i++) {
            for (int j = 0; j < i; j++) {
                if (result[i] < result[j]) {
                    int temp = result[i];
                    result[i] = result[j];
                    result[j] = temp;
                }
            }
        }
        return result;

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
        System.out.println("---------------");
        int[] nums3 = {7,8,9};
        int[] nums4 = {4,5,6};

        int[] result = merge2(nums3, nums4);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

}
