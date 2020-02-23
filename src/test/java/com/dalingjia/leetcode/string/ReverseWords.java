package com.dalingjia.leetcode.string;

/**
 * @author tanhq
 * @Description  557 反转字符串中的单词III
 * @Date 2019/9/6 下午11:53
 * @Version 1.0
 **/
public class ReverseWords {

    public String reverseWords(String s) {
        if (s == null || "".equals(s.trim())) {
            return s;
        }
        String[] strings = s.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String str : strings) {
            result.append(new StringBuilder(str).reverse()).append(" ");
        }

        return result.toString().trim();
    }


    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        String s = "Let's take LeetCode contest";
        reverseWords.reverseWords(s);
    }
}

 
    
    
    
    