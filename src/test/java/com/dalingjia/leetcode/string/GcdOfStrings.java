package com.dalingjia.leetcode.string;

/**
 * @author tanhq
 * @Description  1071 字符串的最大公因子
 * @Date 2019/9/20 下午8:52
 * @Version 1.0
 **/
public class GcdOfStrings {

    public String gcdOfStrings(String str1, String str2) {
        //1,两者分别前后拼接，但是不相等，那么肯定不存在最大公约数
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        //2,如果拆分后的字符串数组中没有剩下任何元素，表明可以被该字符串整除
        //找到两字符串中长度较小的，作为循环次数上限，从后往前依次截取子串，将截取出来的子串用来拆分str1和str2，如果拆分后得到的数组长度为0，则此子串就是最大公约数
        int minLen = Math.min(str1.length(), str2.length());
        for (int i = minLen; i > 0; i--) {
            String s1 = str1.substring(0, i);
            if (str1.split(s1).length == 0 && str2.split(s1).length==0) {
                return s1;
            }
        }
        return "";
    }


    public static void main(String[] args) {
        String[] s = "abc".split("abc");
        System.out.println(s.length);
        System.out.println("abc".substring(0,4));
        System.out.println("abc".substring(0,3));
    }
}

 
    
    
    
    