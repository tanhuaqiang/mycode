package com.dalingjia.leetcodeStudy;

import com.daling.util.NumberUtil;

import java.math.BigDecimal;

/**
 * 14. 最长公共前缀
 */
public class Code14 {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        if (strs == null) {
            return "";
        }
        char[] chars = strs[0].toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            for (int j = 1; j < strs.length; j++) {
                //放在出现字符串长度不够的情况
                if (strs[j].length() - 1 < i || strs[j].charAt(i) != c) {
                    return result.toString();
                }
            }
            result.append(c);
        }
        return result.toString();
    }


    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        //公共前缀比所有字符串都短，随便选一个先
        String s = strs[0];
        for (String string : strs) {
            while (!string.startsWith(s)) {
                if (s.length() == 0) {
                    return "";
                }
                //公共前缀不匹配就让它变短！
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }


    public static Double retainDecimal(Double originNum, Integer scale) {
        BigDecimal bg = BigDecimal.valueOf(originNum);
        return bg.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    public static void main(String[] args) {
        double i = 83.22d;
        double j = 76.66;
        System.out.println(i - j);
        System.out.println(retainDecimal(i - j, 2));
        System.out.println(NumberUtil.numberFormat(2, 4));
        System.out.println(NumberUtil.retainDecimal(50d, 2));
        System.out.println(NumberUtil.retainDecimal(50.0, 2));
        System.out.println(NumberUtil.retainDecimal(50.2, 2));
        System.out.println(NumberUtil.retainDecimal(50.22, 2));
        System.out.println(NumberUtil.retainDecimal(50.223, 2));
    }

}
