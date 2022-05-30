package com.dalingjia.string;

import org.junit.platform.commons.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3, 无重复字符的最长子串
 * 滑动窗口解决
 */
public class MaxSubString {

    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int leng = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                if (allUnique(s, i, j)) {
                    leng = Math.max(leng, j - i);
                } else {
                    break;
                }
            }
        }
        return leng;
    }

    private static boolean allUnique(String s, int i, int j) {
        Set<Character> set = new HashSet<>();
        for (int k = i; k < j; k++) {
            Character character = s.charAt(k);
            if (set.contains(character)) {
                return false;
            } else {
                set.add(character);
            }
        }
        return true;
    }

    /**
     * 滑动窗口解决
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if (StringUtils.isBlank(s)) {
            return 0;
        }
        if (s.length() <= 1) {
            return s.length();
        }
        //定义一个滑动窗口，low代表窗口的左侧位置
        int low = 0;
        //最大长度
        int max = 1;
        char[] chars = s.toCharArray();
        //i代表窗口的右侧位置，i-low+1就代表窗口的长度
        for (int i = 1; i < s.length(); i++) {
            for (int j = low; j < i; j++) {
                //如果字符相等，窗口就要向右侧缩进
                if (chars[j] == chars[i]) {
                    low = j + 1;
                    //后面的字符串没必要比较，肯定不会相等，因为前面的循环已经比较过了
                    break;
                }
            }
            max = max > (i - low + 1) ? max : (i - low + 1);
        }
        return max;
    }

    /**
     * 无重复字符的最长子串
     * 最优解
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for (int i = 0; i < n; i++) {
            //字符转成ASCII码
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println((int) 'a');
        System.out.println(lengthOfLongestSubstring(""));

        System.out.println("tan   hua".replaceAll("\\s+", ""));


    }

}
