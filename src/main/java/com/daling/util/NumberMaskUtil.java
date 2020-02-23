package com.daling.util;

import org.apache.commons.lang3.StringUtils;

public class NumberMaskUtil {

    public static String formatToMask(String string, int start, int end) {
        String formatMask = "";
        if(StringUtils.isNotBlank(string)){
            //\w 匹配字母或数字或下划线或汉字 等价于 '[^A-Za-z0-9_]'
            //\d 匹配数字
            // $1是第一个小括号里的 ,$2是第2个小括号里的
            String regex = "(\\w{" + start + "})(\\w+)(\\w{" + end + "})";
            //使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
            formatMask = string.replaceAll(regex, "$1******$2");
        }
        return formatMask;
    }

    public static void main(String[] args) {
        System.out.println(formatToMask("1837937839237987392",4, 5));
    }
}
