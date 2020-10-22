package com.daling.util;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * @author : tanhq
 * @version :
 * @date : Created in 2020/10/21 下午1:19
 * @description:
 */
public class NumberUtil {

    public static boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }


    public static void main(String[] args) {

        String str = "-1";
        System.out.println(isNumber(str));
        str = "128";
        System.out.println(Integer.valueOf(str));
        System.out.println(isNumber(String.valueOf(Long.MAX_VALUE)));
        System.out.println(isNumber(String.valueOf(Long.MIN_VALUE)));
        System.out.println(isNumber("0"));
        System.out.println(isNumber("3,4"));

        HashMap<String, String> enumMap = new HashMap<>();
        enumMap.put("401", "jlfjs");
        enumMap.put("402", "jlfjs");
        enumMap.put("403", "jlfjs");
        System.out.println(enumMap.containsKey("[403"));

        String value = "[4,3]";
        char s = '[';
        //包含begin,不包含end
        System.out.println(value.substring(1,value.length()-1));

        String ss = " 32, 32,32, 432,   34,7 , 2     ";
        ss = ss.replaceAll("\\s+", "");
        System.out.println(ss);
    }


}
