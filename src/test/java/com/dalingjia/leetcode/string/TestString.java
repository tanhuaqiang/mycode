package com.dalingjia.leetcode.string;

import org.junit.Test;

import java.math.BigDecimal;

public class TestString {

    @Test
    public void testString(){
        String num = "123456789101112131 41516 171819202122232425262728293031323334353637383940";
        char c = num.charAt(30 - 1);
        System.out.println(c);
        BigDecimal i = new BigDecimal(1);
        System.out.println(i.multiply(new BigDecimal(10)).compareTo(new BigDecimal(7)) > 0);
        System.out.println(i.multiply(new BigDecimal(10)).compareTo(new BigDecimal(100)) > 0);
        System.out.println(i.multiply(new BigDecimal(10)).compareTo(new BigDecimal(102)) > 0);
        System.out.println(new BigDecimal(999).toString());
        System.out.println(new BigDecimal(10).divideAndRemainder(new BigDecimal(3))[0]);
        System.out.println(new BigDecimal(10).divideAndRemainder(new BigDecimal(3))[1]);
    }

    /**
     * 算法题：问1到正无穷放在一个无限长字符串里面，求第n位是几
     * 入手点：n是个几位数以及这个数是多少
     * 1，10，100，1000，10000，100000。。。。。
     */
    private  BigDecimal numLengthOfN(BigDecimal n){
        BigDecimal i = new BigDecimal(9); //从一位数开始递增
        BigDecimal count = new BigDecimal(10);
        BigDecimal num = new BigDecimal(1);//查看是几位数
        do {
            if(count.compareTo(n) > 0){
                return num;
            }else {
                i = i.multiply(new BigDecimal(10));
                num = num.add(new BigDecimal(1));
                count = count.add(i.multiply(num));
            }
        }while (true);

    }

    private Integer getIndexOfN(BigDecimal n){
        BigDecimal length = numLengthOfN(n);
        BigDecimal num = null;
        char number = 0;
        //减去不是该位数的所有个数
        for (int i = 1; i <= length.intValue() - 1; i++) {
            n = n.subtract(new BigDecimal(9).multiply(new BigDecimal(Math.pow(10,i-1))).multiply(new BigDecimal(i)));
        }
        BigDecimal shang = n.divideAndRemainder(length)[0];
        BigDecimal yushu = n.divideAndRemainder(length)[1];
        if(length.compareTo(new BigDecimal(1)) == 0){
            return n.intValue();
        }
        //余数是0，取该数的最后一位
        if(yushu.compareTo(new BigDecimal(0)) == 0){
            num = new BigDecimal(Math.pow(10,length.intValue()-1) + shang.intValue()).subtract(new BigDecimal(1));
            number = num.toString().charAt(length.subtract(new BigDecimal(1)).intValue());
        }else{
            num = new BigDecimal(Math.pow(10,length.intValue()-1) + shang.intValue());
            number = num.toString().charAt(yushu.intValue()-1);
        }
        return Integer.parseInt(String.valueOf(number));
    }

    @Test
    public void testNumberOfN(){
        System.out.println(getIndexOfN(new BigDecimal(29589230)));
        System.out.println(getIndexOfN(new BigDecimal(29589231)));
        System.out.println(getIndexOfN(new BigDecimal(29589232)));
        System.out.println(getIndexOfN(new BigDecimal(29589233)));
        System.out.println(getIndexOfN(new BigDecimal(29589234)));
        System.out.println(getIndexOfN(new BigDecimal(29589235)));
        System.out.println(getIndexOfN(new BigDecimal(29589236)));
        System.out.println(getIndexOfN(new BigDecimal(29589237)));
    }
}
