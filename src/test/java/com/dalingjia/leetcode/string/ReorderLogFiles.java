package com.dalingjia.leetcode.string;

import java.util.*;

/**
 * @author tanhq
 * @Description  937 重新排列日志文件
 * @Date 2019/9/18 下午5:32
 * @Version 1.0
 **/
public class ReorderLogFiles {

    public String[] reorderLogFiles(String[] logs) {
        if (logs.length == 0) {
            return new String[]{};
        }
        List<String> numList = new ArrayList<>();
        List<String> charList = new ArrayList<>();
        for (String s : logs) {
            //判断最后一个字符是否是字符
            if (Character.isLetter(s.charAt(s.length()-1))) {
                charList.add(s);
            }else {
                numList.add(s);
            }
        }
        //2.对字符日志排序
        charList.sort((s1,s2) -> {
            //分离出日志内容和日志头
            int s1Flag = s1.indexOf(" ");
            String s1Content = s1.substring(s1Flag + 1, s1.length());
            String s1Head = s1.substring(0, s1Flag);
            int s2Flag = s2.indexOf(" ");
            String s2Content = s2.substring(s2Flag + 1, s2.length());
            String s2Head = s2.substring(0, s2Flag);
            //首先判断内容是否相同
            if (!s1Content.equals(s2Content)) {
                return s1Content.compareTo(s2Content);
            }
            //如果内容相同比较日志头
            return s1Head.compareTo(s2Head);
        });

        //3.将数字日志添加到排序号的字符日志之后，返回结果
        charList.addAll(numList);
        return charList.toArray(new String[charList.size()]);
    }
}

 
    
    
    
    