package com.dalingjia.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tanhq
 * @Description   赎金信
 * @Date 2019/8/22 上午10:32
 * @Version 1.0
 **/
public class CanConstruct {

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map1 = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            if(!map1.containsKey(magazine.charAt(i))){
                map1.put(magazine.charAt(i), 1);
            }else {
                map1.put(magazine.charAt(i), map1.get(magazine.charAt(i))+ 1);
            }
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if(!map1.containsKey(ransomNote.charAt(i))){
                return false;
            }else {
                map1.put(ransomNote.charAt(i), map1.get(ransomNote.charAt(i)) - 1);
                if(map1.get(ransomNote.charAt(i)) == 0){
                    map1.remove(ransomNote.charAt(i));
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        canConstruct("aa", "aab");
    }


    /**
     * 具体思路是统计magazine中包含的所有单词和对应的出现次数，接下来遍历ransom中每一个字母，再magazine中找到后，把出现次数减一，
     * 再判断次数是否还大于0，若小于0，说明magazine中没有这个字母或者相同的字母数不够，返回false，否则返回true。
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct2(String ransomNote, String magazine) {
        int [] res=new int[26];
        for(int i=0;i<magazine.length();i++){
            res[magazine.charAt(i)-'a']++;
        }
        for(int i=0;i<ransomNote.length();i++){
            int k=--res[ransomNote.charAt(i)-'a'];
            if(k<0)
                return false;
        }
        return true;
    }

}

 
    
    
    
    