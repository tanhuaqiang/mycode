package com.dalingjia.leetcode.string;

/**
 * leetcode 14 最长公共前缀
 */
public class LongestCommonPrefix {

    private static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length <= 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = strs.length;
        //取第一个字符串，然后再取里面的字符串进行比较
        char[] chars = strs[0].toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c =chars[i];
            for (int j = 1; j < length; j++) {
                if(strs[j].length()-1 >= i && strs[j].charAt(i) == c){
                    continue;
                }else {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"flower","flow","flight","fgajl"};
//        String[] strings2 = {"aa","a"};
        System.out.println(longestCommonPrefix(strings));
        String[] strings2 = {"aaaa"};
        System.out.println(longestCommonPrefix(strings2));
    }
}
