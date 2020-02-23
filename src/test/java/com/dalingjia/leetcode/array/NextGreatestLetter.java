package com.dalingjia.leetcode.array;

/**
 * @author tanhq
 * @Description  744 寻找比目标字母大的最小字母
 * @Date 2019/9/16 下午9:21
 * @Version 1.0
 **/
public class NextGreatestLetter {

    public char nextGreatestLetter(char[] letters, char target) {
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > target) {
                return letters[i];
            }
        }
        return letters[0];
    }

}

 
    
    
    
    