package com.dalingjia.leetcode.array;


/**
 * leetcode 27 移除元素
 */
public class RemoveElement {

    private static int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n){
            if(nums[i] == val){
                //用数组最后一个元素替换掉指定的元素
                nums[i] = nums[n - 1];
                n--;
            }else {
                i++;
            }
        }
        return i;
    }

    public int removeElement2(int[] nums, int val) {
        int index = 0;
        for (int i = index; i < nums.length; i++) {
            if(val != nums[i]){
                nums[index++] = nums[i];
            }
        }
        return index;

    }
}
