package com.dalingjia.leetcode.string;

/**
 * @author tanhq
 * @Description 541 反转字符串II
 * @Date 2019/9/6 下午10:39
 * @Version 1.0
 **/
public class ReverseStr {

    /**
     * abcdefg
     *
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        int length = s.length();
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < length; i += 2 * k) {
            if (length - i < k) {
                temp.append(s.substring(i)).reverse();
                result.append(temp);
            } else if (length - i < 2 * k) {
                temp.append(s.substring(i,i+k)).reverse();
                result.append(temp).append(s.substring(i + k));
            }else {
                temp.append(s.substring(i, i + k)).reverse();
                result.append(temp).append(s.substring(i+k,i+2*k));
                temp = new StringBuilder();
            }
        }
        return result.toString();
    }


    /**
     * 方法二：数组的反转用的很好，指的借鉴
     * @param s
     * @param k
     * @return
     */
    public String reverseStr2(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        while(i < n) {
            //比较索引位置，取最小值
            int j = Math.min(i + k - 1, n - 1);
            swap(arr, i, j);
            i += 2 * k;
        }
        return String.valueOf(arr);
    }
    private static void swap(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }

}

 
    
    
    
    