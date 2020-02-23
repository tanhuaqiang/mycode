package com.dalingjia.leetcode.string;

/**
 * @author tanhq
 * @Description 1160 拼写单词
 * @Date 2019/9/22 下午1:15
 * @Version 1.0
 **/
public class CountCharacters {

    public int countCharacters(String[] words, String chars) {
        int[] ints = new int[26];
        int count = 0;
        char[] chars1 = chars.toCharArray();
        //1,记录每个字符的个数
        for (int i = 0; i < chars1.length; i++) {
            ints[chars1[i] - 'a']++;
        }
        for (String s : words) {
            char[] c = s.toCharArray();
            int[] temp = new int[26];
            //2，记录字符串中每个字符的个数
            for (char ch : c) {
                temp[ch - 'a']++;
            }
            boolean flag = true;
            //3，进行比较
            for (char ch : c) {
                if (temp[ch - 'a'] > ints[ch - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count += s.length();
            }

        }
        return count;
    }


}

 
    
    
    
    