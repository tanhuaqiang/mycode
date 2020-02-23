package com.dalingjia.leetcode.array;

public class BigNumberAdd {

    private static String add(String num1, String num2) {
        //1，使用int来表示大整数的长度足够，定义和的长度
        int maxength = (num1.length() > num2.length()) ? num1.length() : num2.length();
        //2, 用数组来表示和，考虑进位，所以加一位长度
        int[] result = new int[maxength + 1];

        int[] numArray1 = new int[maxength];
        int[] numArray2 = new int[maxength];
        int t1 = 0;
        int t2 = 0;
        //3, 将两个大整数倒序放到数组中
        for (int i = num1.length()-1; i>=0 ; i--) {
            numArray1[t1++] = num1.charAt(i) - '0';
        }
        for (int i = num2.length()-1; i>=0 ; i--) {
            numArray2[t2++] = num2.charAt(i) - 48;
        }
        //4，将两个数组的每个元素位进行相加，进位放到后一位
        for (int i = 0; i < numArray1.length; i++) {
            int sum = numArray1[i] + numArray2[i] + result[i];
            if(sum >= 10){
                result[i] = sum - 10;
                result[i+1] = 1;
            }else {
                result[i] = sum;
            }
        }
        //5，反转数组，即为所求的和
        StringBuilder sb = new StringBuilder();
        for (int i = result.length-1; i >= 0 ; i--) {
            if(result[result.length-1]==0){
                continue;
            }
            sb.append(result[i]);
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String num1 = "426709752318";
        String num2 = "954812531295";
        System.out.println(add(num1, num2));
    }
}
