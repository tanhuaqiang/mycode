package com.dalingjia.leetcode.string;

/**
 * @author tanhq
 * @Description 647 回文子串
 * @Date 2019/10/1 上午7:20
 * @Version 1.0
 **/
public class CountSubstrings {

    public int countSubstrings(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            //1:以i为中心的回文串；2: 以i为左中心的回文串
            count += countString(s, i, i);
            count += countString(s, i, i + 1);
        }
        return count;
    }

    private int countString(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            //像两边扩展
            l--;
            r++;
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        CountSubstrings c = new CountSubstrings();
        System.out.println(c.countSubstrings("baab"));
    }
}

 
    
    
    
    