package com.dalingjia.string;

import com.alibaba.druid.sql.visitor.functions.Char;
import org.junit.platform.commons.util.StringUtils;

/**
 * @author tanhq
 * @Description TODO
 * @Date 2022/6/11 下午5:47
 * @Version 1.0
 **/
public class Testaa {


    /**
     * 无重复字符的最长子串
     * @param s
     * @return
     */
    public static String longestSubstring(String s) {
        if (StringUtils.isBlank(s)) {
            return "";
        }
        if (s.length() <= 1) {
            if (!method(s.charAt(0))) {
                return "";
            }else {
                return s;
            }
        }
        //定义一个滑动窗口，low代表窗口的左侧位置
        int low = 0;
        //最大长度
        int max = 1;
        String result = "";
        char[] chars = s.toCharArray();
        //i代表窗口的右侧位置，i-low+1就代表窗口的长度
        for (int i = 1; i < s.length(); i++) {
            for (int j = low; j < i; j++) {
                if (!method(chars[i]) || !method(chars[j])) {
                    low = j + 1;
                    //后面的字符串没必要比较，肯定不会相等，因为前面的循环已经比较过了
                    break;
                }
            }
            if (max <= (i - low + 1)) {
                max = i -low +1;
                result = s.substring(low, i+1);
            }
//            max = max > (i - low + 1) ? max : (i - low + 1);
//            result = max > (i - low + 1) ? result : s.substring(low, i+1);
        }
        return result;
    }

    private static boolean method(char c) {
        if (c == ' ' || (65 <= c && c <= 90)
                || (97 <= c && c <= 122)) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String s = ":LSu9f*&;23lk45";
        System.out.println(longestSubstring(s));
    }
}

 
    
    
    
    