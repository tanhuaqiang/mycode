package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description leetcode 215 数组中的第K个最大元素
 * @Date 2019/11/24 上午11:40
 * @Version 1.0
 **/
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }
    /**
     * 使用快排思想
     */
    private int quickSort(int[] nums, int left, int right, int k) {
        int mark = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && nums[j] >= mark) {
                j--;
            }
            while (i < j && nums[i] <= mark) {
                i++;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        //此时i == j
        nums[left] = nums[i];
        nums[i] = mark;
        //计算第k大的元素的下标是否是i
        if (i == nums.length - k) {
            return nums[i];
        } else if (i < nums.length - k) {
            return quickSort(nums, i+1, right, k);
        }else {
            return quickSort(nums, left, i - 1, k);
        }
    }
}

 
    
    
    
    