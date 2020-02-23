package com.dalingjia.leetcode.string;

/**
 * @author tanhq
 * @Description  844 比较含退格的字符串
 * @Date 2019/9/17 下午7:24
 * @Version 1.0
 **/
public class BackspaceCompare {

    public boolean backspaceCompare(String S, String T) {

        return dfs(S).equals(dfs(T));
    }

    private String dfs(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                sb.append(s.charAt(i));
            }else {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }

            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("a");
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
        System.out.println("".equals(""));
    }
}

 
    
    
    
    