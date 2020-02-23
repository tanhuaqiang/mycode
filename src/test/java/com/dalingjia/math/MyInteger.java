package com.dalingjia.math;

public class MyInteger {

    public static int parseInt(String s) {
        return parseInt(s, 10);
    }

    public static int parseInt(String s, int radix) {
        int result = 0;
        int i = 0;
        int digit;
        boolean nagitive = false;
        int length = s.length();
        if (length > 0) {
            char firstChar = s.charAt(0);
            //+,-号
            if (firstChar < '0') {
                if (firstChar == '-') {
                    nagitive = true;
                } else if (firstChar != '+') {
                    throw new NumberFormatException();
                }
                //只有一个符号
                if (length == 1) {
                    throw new NumberFormatException();
                }
                //向后取数值位
                i++;
            }

            while (i < length) {
                //取字符串的第i个字符转int
                digit = Character.digit(s.charAt(i++), radix);
                //乘10
                result *= radix;
                //减数值
                result -= digit;
            }

        } else {
            throw new NumberFormatException();
        }
        return nagitive ? result : -result;
    }

    public static int strToInt(String string) {
        if ("0".equals(string) || string.length() == 0 || string == "") {
            return 0;
        }
        int sum = 0;
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '+' || chars[i] == '-') {
                continue;
            }
            if (chars[i] < '0' || chars[i] > '9') {
                return 0;
            } else {
                //为了求出整数值，必须和'0'相减
                sum = (chars[i] - '0') + sum * 10;
            }
        }
        if (chars[0] == '-') {
            sum = sum * (-1);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(strToInt("+322"));
        System.out.println(strToInt("+5564a5423"));
        System.out.println(strToInt("-643123"));
        //向上转型
        System.out.println('3' + 0);
        //全部转换成十进制的数进行计算
        System.out.println('3' - '0' + 0);

        char a = '3';
        char b = '0';
        System.out.println("a+b= " + (a - b));
    }
}
