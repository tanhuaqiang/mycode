package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description TODO
 * @Date 2019/8/8 下午5:38
 * @Version 1.0
 **/
public class TargetArray {

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == target - numbers[j]) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return null;
    }

    public static String convertToTitle(int n) {

        String[] strings = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",};

        StringBuilder sb = new StringBuilder();
        while (n > 26) {

            int remainder = n % 26;

            if (remainder == 0) {
                sb.append(strings[strings.length - 1]);
                n = (n - 26) / 26;
            } else {
                sb.append(strings[remainder - 1]);
                n = (n - remainder) / 26;
            }

        }
        sb.append(strings[n - 1]);
        return sb.reverse().toString();

    }

    public static String convertToTitle2(int n) {

        String temp = "";
        while (n > 0) {
            char s = (char) ((n - 1) % 26 + 'A');
            temp = s + temp;
            n = (n - 1) / 26;
        }
        return temp;
    }

    public static int titleToNumber(String s) {
        int sum = 0;
        int temp = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            int number = (s.charAt(i) - 'A' + 1) * temp;
            temp *= 26;
            sum += number;
        }
        return sum;
    }

    public static int titleToNumber2(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++)
        {
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        }
        return result;

    }


    public static void main(String[] args) {
        System.out.println(titleToNumber("Z"));
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("AZ"));
        System.out.println(titleToNumber("ZY"));
        System.out.println(titleToNumber("NTP"));
    }

}

 
    
    
    
    