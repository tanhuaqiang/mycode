package com.dalingjia.leetcode.string;

public class AAA {

    public static void main(String[] args) {

        String regex = ",";
        char ch = 0;
        if (
                (   //如果regex只有一位，且不为列出的特殊字符
                    (regex.length() == 1 && ".$|()[{^?*+\\".indexOf(ch = regex.charAt(0)) == -1)
                            ||
                    //如果regex有2位，第一位为转义字符，且第二位不是数字或字母
                    /**
                     * “||”:   如果左边计算后的操作数为true,右边则不再执行，返回true；
                     *
                     * “|”：前后两个操作数都会进行计算。也就是说：“|”不存在短路。
                     */
                    (regex.length() == 2 && regex.charAt(0) == '\\' && ( ((ch = regex.charAt(1))-'0')|('9'-ch) ) < 0 && ((ch-'a')|('z'-ch)) < 0 && ((ch-'A')|('Z'-ch)) < 0)
                )
                        &&
                /**
                 *  UTF-16 编码中的 Unicode 高代理项代码单元的最小值, '\uD800'
                 *  UTF-16 编码中的 Unicode 低代理项代码单元的最大值, '\uDFFF'
                 */
                (ch < Character.MIN_HIGH_SURROGATE || ch > Character.MAX_LOW_SURROGATE)
            ){
            System.out.println("I am tanhq !");
        }

//        String s1 = "ac,dge,grhr,ljs";
//        String[] strings1 = s1.split(",");
//        for (int i = 0; i < strings1.length; i++) {
//            System.out.println(strings1[i]);
//        }
//
//        String s2 = "ac\'dge\'grhr\'ljs";
//        String[] strings2 = s2.split("\\'");
//        for (int i = 0; i < strings2.length; i++) {
//            System.out.println(strings2[i]);
//        }

        String ss = "33ac32dge533grhr139ljs";
        String[] strings = ss.split("[\\d]+");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
        String tt = "[\\d]+";
        System.out.println(tt);

    }
}
