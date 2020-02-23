package com.dalingjia.leetcode.string;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 手动实现java的split()方法
 */
public class SpiltUtil {

    private static final String contant = ".$|()[{^?*+\\";

    public static String[] splitMethod(String string, String regex) {
        char ch = 0;
        int off = 0;
        int next = 0;
        ArrayList<String> list = Lists.newArrayList();
        if (regex.length() == 1 && contant.indexOf(ch = regex.charAt(0)) == -1 ||
                regex.length() == 2 && regex.charAt(0) == '\\' && ((ch = regex.charAt(1)) - '0' | '9' - ch) < 0 && (ch - 'a' | 'z' - ch) < 0 && (ch - 'A' | 'Z' - ch) < 0) {
            while ((next = string.indexOf(ch, off)) > 0) {
                list.add(string.substring(off, next));
                off = next + 1;
            }
            if (off == 0) {
                return new String[]{string};
            }
            list.add(string.substring(off, string.length()));
            return interceptEmpty(list);
        }
        return regexSplit(string, regex);
    }

    private static String[] regexSplit(String string, String regex) {
        int off = 0;
        //将给定的正则表达式编译到模式中
        Pattern pattern = Pattern.compile(regex);
        //创建给定输入与此模式匹配的匹配器
        Matcher m = pattern.matcher(string);
        List<String> list = Lists.newArrayList();
        while (m.find()) {
            //m.start(): 返回第一个匹配字符的索引
            list.add(string.substring(off, m.start()));
            //m.end(): 返回最后匹配字符之后的偏移量
            off = m.end();
        }
        if (off == 0) {
            return new String[]{string};
        }
        list.add(string.substring(off, string.length()));
        return interceptEmpty(list);
    }

    //截取空字符串
    private static String[] interceptEmpty(List<String> list) {
        //截取空的字符串
        int resultSize = list.size();
        while (resultSize > 0 && list.get(resultSize - 1).length() == 0) {
            resultSize--;
        }
        String[] strings = new String[resultSize];
        return list.subList(0, resultSize).toArray(strings);
    }

    //测试方法
    @Test
    public void test() {
        //测试regex只有一位，且不为列出的特殊字符
        String s1 = "gg,tge,hbfs,ijkd,,,";
        String[] strings1 = splitMethod(s1, ",");
        for (int i = 0; i < strings1.length; i++) {
            System.out.println(strings1[i]);
        }

        //测试regex有两位，第一位位转义字符且第二位不是数字和字母
        String s2 = "bb\'dn\'ags\'kl\'\'";
        String[] strings2 = splitMethod(s2, "\\'");
        for (int i = 0; i < strings2.length; i++) {
            System.out.println(strings2[i]);
        }

        //测试正则表达式
        String ss = "22ac32dge533grhr139ljs343";
        String[] strings = splitMethod(ss, "[\\d]+");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }

        ss.split(",");
    }
}
