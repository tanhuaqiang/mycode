package com.dalingjia.leetcode.string;

import java.util.*;

/**
 * @author tanhq
 * @Description  551 学生出勤记录I
 * @Date 2019/9/6 下午11:35
 * @Version 1.0
 **/
public class CheckRecord {

    /**
     * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏
     * @param s
     * @return
     */
    public boolean checkRecord(String s) {
        Map<Character, Integer> map = new HashMap();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                map.put('A', map.getOrDefault('A',0) + 1);
                if (map.get('A') > 1) {
                    return false;
                }
                count = 0;
            }else if (s.charAt(i) == 'L'){
                count++;
                if (count > 2) {
                    return false;
                }
            }else {
                count = 0;
            }
        }
        return true;
    }

    public boolean checkRecord2(String s) {
        int countA = 0;
        int countL = 0;
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (c == 'A') {
                countA++;
                countL = 0;
            } else if (c == 'L') {
                countL++;
            }else {
                countL = 0;
            }
            if (countA > 1 || countL > 2) {
                return false;
            }
        }
        return true;
    }
}

 
    
    
    
    