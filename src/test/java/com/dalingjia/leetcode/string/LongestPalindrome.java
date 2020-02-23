package com.dalingjia.leetcode.string;

/**
 * @author tanhq
 * @Description 5 最长回文子串
 * @Date 2019/8/22 下午6:31
 * @Version 1.0
 **/
public class LongestPalindrome {

    /**
     * leetcode 5 最长回文子串 最优解
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        //定义回文子串的开始节点和最后节点的下标
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            //单核回文  bab
            int len1 = expandAroundCenter(s, i, i);
            //双核回文  baab
            int len2 = expandAroundCenter(s, i, i + 1);
            //取较大长度的
            int len = Math.max(len1, len2);
            if (len > end - start) {
                //兼容单核双核2种情况，所以求start时要先减1
                //bab  baab  i为a所在下标
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * 该方法返回回文子串的长度
     *
     * @param s
     * @param left
     * @param right
     * @return
     */
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        //由于先做了扩展操作，所以还要做一次收缩，下面的式子等价于(R - L + 1) - 2
        return R - L - 1;
    }

}

 
    
    
    
    