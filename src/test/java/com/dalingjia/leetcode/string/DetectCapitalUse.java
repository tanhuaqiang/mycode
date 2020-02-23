package com.dalingjia.leetcode.string;

/**
 * @author tanhq
 * @Description  520 检测大写字母
 * @Date 2019/9/5 下午9:35
 * @Version 1.0
 **/
public class DetectCapitalUse {

    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) {
            return true;
        }
        if (word.charAt(0) >= 'a' && word.charAt(0) <= 'z') {
            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i) < 'a' || word.charAt(i) > 'z') {
                    return false;
                }
            }
        }else {
            if(word.charAt(1) >= 'a' && word.charAt(1) <= 'z'){
                for (int i = 2; i < word.length(); i++) {
                    if (word.charAt(i) < 'a' || word.charAt(i) > 'z') {
                        return false;
                    }
                }
            }else {
                for (int i = 2; i < word.length(); i++) {
                    if (word.charAt(i) < 'A' || word.charAt(i) > 'Z') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean detectCapitalUse2(String word) {
        if (word.length() == 1) {
            return true;
        }
        if (word.toUpperCase().equals(word)) {
            return true;
        }
        if (word.substring(1).toLowerCase().equals(word.substring(1))) {
            return true;
        }
        return false;
    }
}

 
    
    
    
    