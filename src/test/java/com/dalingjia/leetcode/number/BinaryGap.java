package com.dalingjia.leetcode.number;

/**
 * @author tanhq
 * @Description 868 二进制间距
 * @Date 2019/9/17 下午10:18
 * @Version 1.0
 **/
public class BinaryGap {

    public static int binaryGap(int N) {
        String s = "";
        while (N > 0) {
            s = (N & 1) + s;
            N >>= 1;
        }
        //定义2个指针
        int index = -1;
        int index2 = -1;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (index == -1) { //第一个指针
                    index = i;
                } else if (index2 == -1) { //第二个指针
                    index2 = i;
                    max = Math.max(max, index2 - index);
                } else {
                    index = index2; //指针移动
                    index2 = i;
                    max = Math.max(max, index2 - index);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        binaryGap(13);
    }


    public static int binaryGap2(int N) {
        int[] arr = new int[32];//初始化一个新的数组 ，默认长度为32位
        int bit = 0;   //为1的位
        int cnt = 0;   //间距
        /**
         * N >> i 是将N转为二进制右移i位后的值，再&1则是判断哪一个位置为1.
         */
        for (int i = 0; i < arr.length; ++i) {
            if (((N >> i) & 1) != 0) {  //判断转为二进制哪个位置的值为1
                arr[bit++] = i;  //第i位的值为1
            }
        }

        for (int i = 0; i < bit; i++) {
            cnt = Math.max(arr[i + 1] - arr[i], cnt); //获取最大差值，即最大间距
        }
        return cnt;
    }

}

 
    
    
    
    