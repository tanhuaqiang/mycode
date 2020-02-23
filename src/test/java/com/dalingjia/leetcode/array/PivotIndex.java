package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description 724 寻找数组的中心索引
 * @Date 2019/9/16 下午8:55
 * @Version 1.0
 **/
public class PivotIndex {

    /**
     * 我的解法
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            for (int j = 0; j < i; j++) {
                left += nums[j];
            }
            int right = sum - left - nums[i];
            if (left == right) {
                return i;
            }

        }
        return -1;
    }


    /**
     * 最优解
     * @param nums
     * @return
     */
    public int pivotIndex2(int[] nums) {
        if(nums.length<2){
            return -1;
        }
        int sum=0;
        int leftSum=0;
        int rightSum=0;
        for(int num:nums){
            sum+=num;
        }
        for(int i=0;i<nums.length;i++){
            if(i==0){
                leftSum=0;
            }else{
                leftSum+=nums[i-1];
            }
            rightSum=sum-leftSum-nums[i];
            if(rightSum==leftSum){
                return i;
            }
        }
        return -1;
    }

}

 
    
    
    
    