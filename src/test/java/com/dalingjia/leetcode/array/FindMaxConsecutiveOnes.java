package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description  485  最大连续1的个数
 * @Date 2019/9/5 下午5:18
 * @Version 1.0
 **/
public class FindMaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }
        int max = 0;
        StringBuilder sb = new StringBuilder();
        for (int n : nums) {
            sb.append(n);
        }
        String[] strings = sb.toString().split("0");
        for (String s : strings) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }

    public int findMaxConsecutiveOnes2(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1){
                count++;
            }else {
                count=0;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        String[] s = "010".split("0");
        System.out.println(s);
        System.out.println(Math.max(0,1));
        System.out.println(Math.max(0,0));
    }
}

 
    
    
    
    