package com.dalingjia.util.StringUtil;

public class StringFormatTest {

    public static void main(String[] args) {
        //其中“1$”的数字表示参数位置
        /**
         * %n$ms：代表输出的是字符串，n代表是第几个参数，设置m的值可以在输出之前放置空格 
         * %n$md：代表输出的是整数，n代表是第几个参数，设置m的值可以在输出之前放置空格，也可以设为0m,在输出之前放置m个0 
         * %n$mf：代表输出的是浮点数，n代表是第几个参数，设置m的值可以控制小数位数，如m=2.2时，输出格式为00.00 
         */
        System.out.println(String.format("【编号%1$d】%2$s", 123, "tanhq"));

        //“%”后面的字母表示数据类型
        System.out.println(String.format("描述：%s", "aaaa"));
        System.out.println(String.format("描述：%s", 222));

        //表示小数点后保留2位
        System.out.println(String.format("%.2f元", 13.6736));

        //表示8位整数，不够前面补0
        System.out.println(String.format("编号：%08d", 273634));

        String cardNo = "65550404014413045";
        cardNo.replaceAll("(\\d{4})\\d{10}(\\w{4})", "$1**********$2");
        System.out.println(cardNo);
    }
}
