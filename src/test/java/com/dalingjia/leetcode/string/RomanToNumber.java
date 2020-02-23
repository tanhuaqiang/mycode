package com.dalingjia.leetcode.string;

import com.google.common.collect.Maps;

import java.util.Map;

public class RomanToNumber {

    private static int romanToInt(String s) {
        Map<Character, Integer> map = Maps.newHashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum = 0;
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            if((i !=length-1) && (method(s.substring(i,i+2)) != 0)){
                sum += method(s.substring(i, i + 2));
                i++;
            }else {
                sum += map.get(chars[i]);
            }
        }
        return sum;
    }

    private static int method(String s) {
        int sum = 0;
        if("IV".equals(s)){
            sum = 4;
        }else if("IX".equals(s)){
            sum = 9;
        }else if("XL".equals(s)){
            sum = 40;
        }else if("XC".equals(s)){
            sum = 90;
        }else if("CD".equals(s)){
            sum = 400;
        }else if("CM".equals(s)){
            sum = 900;
        }
        return sum;
    }

    //第二种方法
    private static int method2(String s){
        int result = 0;
        int length = s.length();
        if (s.contains("IV") || s.contains("IX")) result -= 2;
        if (s.contains("XL") || s.contains("XC")) result -= 20;
        if (s.contains("CD") || s.contains("CM")) result -= 200;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    result += 1;break;
                case 'V':
                    result += 5;break;
                case 'X':
                    result += 10;break;
                case 'L':
                    result += 50;break;
                case 'C':
                    result += 100;break;
                case 'D':
                    result += 500;break;
                case 'M':
                    result += 1000;break ;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println("MCMXCIV".contains("CM"));
    }
}
