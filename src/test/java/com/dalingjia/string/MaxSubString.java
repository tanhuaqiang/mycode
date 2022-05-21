package com.dalingjia.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3, 无重复字符的最长子串
 */
public class MaxSubString {

    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int leng = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j <= length; j++) {
                if(allUnique(s, i, j)){
                    leng = Math.max(leng, j - i);
                }else {
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
            if(set.contains(character)){
                return false;
            }else {
                set.add(character);
            }
        }
        return true;
    }

    public static int getLength(String s){
        int n = s.length(), ans = 0;
        // current index of character, 从1开始计算
        Map<Character, Integer> map = new HashMap<>();
        // try to extend the range [i, j]
        for (int i = 0, j = 0; j < n; j++) {
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j+1);
        }
        return ans;
    }

    public static int lengthOfLastWord(String s) {
        int length = 0;
        if(s != null && !"".equals(s.trim())){
            String[] strings = s.split("\\s+");
            length = strings[strings.length - 1].length();
        }
        return length;
    }

    /**
     * 无重复字符的最长子串
     * 最优解
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            //字符转成ASCII码
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println((int)'a');
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(getLength("abcabcbb"));
        System.out.println(getLength("abccbaaa"));
        System.out.println(getLength("aaaaa"));
        System.out.println(getLength(""));

        System.out.println(lengthOfLastWord(null));
        System.out.println(lengthOfLastWord(" "));
        System.out.println(lengthOfLastWord("Hell "));
        System.out.println(lengthOfLastWord("Hello   world"));
        System.out.println("tan   hua".replaceAll("\\s+", ""));
    }

}
