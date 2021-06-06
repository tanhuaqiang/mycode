package com.dalingjia.leetcodeStudy;

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
                if (strs[j].length()-1 < i || strs[j].charAt(i) != c) {
                    return result.toString();
                }
            }
            result.append(c);
        }
        return result.toString();
    }

}
