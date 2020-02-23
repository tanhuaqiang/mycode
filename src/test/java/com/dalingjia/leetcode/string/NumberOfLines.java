package com.dalingjia.leetcode.string;

/**
 * @author tanhq
 * @Description 806 写字符串需要的行数
 * @Date 2019/9/17 下午4:30
 * @Version 1.0
 **/
public class NumberOfLines {

    public int[] numberOfLines(int[] widths, String S) {
        int[] result = {1, 0};
        char[] chars = S.toCharArray();
        int len = chars.length;
        int space = 100;//每行剩余空间
        for (int i = 0; i < len; i++) {
            if (widths[chars[i] - 'a'] <= space) {
                space -= widths[chars[i] - 'a'];
            } else {
                result[0] += 1;//换行
                space = 100;
                space -= widths[chars[i] - 'a'];
            }
        }
        result[1] = 100 - space;
        return result;
    }


}

 
    
    
    
    