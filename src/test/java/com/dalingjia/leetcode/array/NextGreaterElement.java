package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description  496 下一个更大元素I
 * @Date 2019/9/5 下午5:40
 * @Version 1.0
 **/
public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        for (int i = 0; i < nums1.length; i++) {

            //1,找到num1[i]在num2中所处的位置
            int index = findIndex(nums1[i], nums2);
            //2,判断是否找到第一个大于该元素的值
            boolean flag = false;
            for (int j = index + 1; j < nums2.length; j++) {
                if(nums1[i] < nums2[j]){
                    nums1[i] = nums2[j];
                    flag = true;
                    break;
                }
            }
            if(!flag){
                nums1[i] = -1;
            }

        }
        return nums1;
    }

    private int findIndex(int i, int[] nums2) {
        for (int j = 0; j < nums2.length; j++) {
            if(i == nums2[j]){
                return j;
            }
        }
        return 0;
    }


}

 
    
    
    
    