package com.dalingjia.leetcodeStudy;

/**
 * 整数反转
 */
public class Code7 {

    public static int reverse(int x) {

        int result = 0;
        while (x != 0) {

            /**
             * result保存反转旧的中间值
             * temp 保存新的反转过程中间值，依次读取x的末位置加入temp
             * 如果发生溢出，则通过temp/10无法得到上一轮的翻转结果result
             */
            int temp = result * 10 + x % 10;
            //如果发生溢出，则通过temp/10无法得到上一轮的翻转结果result
            if (temp / 10 != result) {
                return 0;
            }
            x /= 10;
            result = temp;
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(321));
        System.out.println(reverse(-123));
    }
}
