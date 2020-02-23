package com.dalingjia.leetcode.string;

/**
 * @author tanhq
 * @Description  反转字符串的元音字母
 * @Date 2019/8/21 下午6:31
 * @Version 1.0
 **/
public class ReverseVowels {

    public String reverseVowels(String s) {
        if("".equals(s) || s.length() < 2){
            return s;
        }
        int i = 0;
        int j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i < j) {
            if(isVowel(chars[i]) && isVowel(chars[j])){
                char temp = chars[i];
                chars[i++] = chars[j];
                chars[j--] = temp;
            }else if(isVowel(chars[i])){
                j--;
            }else {
                i++;
            }
        }
        return String.valueOf(chars);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e'|| c == 'i'|| c == 'o'|| c == 'u'
                || c == 'A' || c == 'E'|| c == 'I'|| c == 'O'|| c == 'U';
    }
}

 
    
    
    
    