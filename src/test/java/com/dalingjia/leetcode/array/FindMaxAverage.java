package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description 643 子数组最大平均数I
 * @Date 2019/9/8 下午5:58
 * @Version 1.0
 **/
public class FindMaxAverage {

    /**
     * Double.NEGATIVE_INFINITY 表示负无穷
     * Double.MIN_VALUE 表示的是64位双精度值能表示的最小正数
     *
     * @param nums
     * @param k
     * @return
     */
    public static double findMaxAverage(int[] nums, int k) {
        double max = -1000000L;
        int n = nums.length;
        for (int i = 0; i <= n - k; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += nums[i + j];
            }
            max = Math.max(max, sum);
        }
        return max / k;
    }


    public static double findMaxAverage2(int[] nums, int k) {
        double maxAvg = Double.NEGATIVE_INFINITY;
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k - 1) {
                if (i > k - 1) {
                    sum = sum - nums[i - k];
                }
                if (sum / k > maxAvg) maxAvg = sum / k;
            }
        }
        return maxAvg;

    }

    public static void main(String[] args) {
        int[] ints = {-1};
        System.out.println(findMaxAverage(ints, 1));
        System.out.println(Double.MIN_VALUE > 0);
        System.out.println(Double.NEGATIVE_INFINITY > 0);
    }
}





