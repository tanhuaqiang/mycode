package com.dalingjia.leetcode.array;

import java.util.*;

/**
 * @author tanhq
 * @Description   找到数组中所有消失的数字
 * @Date 2019/8/23 下午10:10
 * @Version 1.0
 **/
public class FindDisappearedNumbers {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        //遍历数组，将数组上本该放置该元素的位置上置反
        for(int i = 0;i < nums.length;i++){
            int value = Math.abs(nums[i]) - 1;
            if(nums[value] > 0){
                nums[value] = -nums[value];
            }
        }
        //检查位置上为被置反的元素，将其添加到list中
        for(int i = 0;i < nums.length;i++){
            if(nums[i] > 0){
                list.add(i + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] ints = {4, 3, 2, 7, 8, 2, 3, 2};
        System.out.println(findDisappearedNumbers(ints));
    }
}

 
    
    
    
    