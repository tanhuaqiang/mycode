package com.dalingjia.leetcode.array;

/**
 * 连续子数组的最大和
 * 寻找数组中最大子序列的和
 * {6,-3,-2,7,-15,1,2,2}
 */
public class FindGreatestSumOfSubArray {

    public static int find(int[] arr) {
        int sum = 0;
        int start = 0;
        int end = 0;
        if (arr == null || arr.length <= 0) {
            return 0;
        }
        for (int i = 0; i < arr.length; i++) {
            int temp = 0;
            for (int j = i; j < arr.length; j++) {
                temp += arr[j];
                if (temp > sum) {
                    sum = temp;
                    start = i;
                    end = j;
                }
            }
        }
        System.out.println("start=" + start + ", end=" + end);
        return sum;
    }

    private static int findGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            try {
                throw new Exception("重新考虑输入");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //用于保存已经找到的连续子数组的最大和
        int maxSum = array[0];
        //当前最大和
        int currentSum = array[0];
        int begin = 0, end = 0, currentIndex = 0;
        //从数组的第二个数开始计算
        for (int i = 1; i < array.length; i++) {
            //如果currentSum<0,则说明从开始位置到i-1的位置的值<0, 因此从数组下标的第i个位置开始寻找
            if (currentSum < 0) {
                currentSum = array[i];
                currentIndex = i;
            } else {
                currentSum += array[i];
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                begin = currentIndex;
                end = i;
            }
        }
        System.out.println("开始："+ begin + " 结束：" + end);
        return maxSum;
    }


    public static void main(String[] args) {
        int[] arr = {6, -3, -8, 2, 15, 1, -5, 9};
        System.out.println(findGreatestSumOfSubArray(arr));
    }

}
