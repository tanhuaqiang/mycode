package com.dalingjia.JVM;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * JDK8里面移除了永生代
 * 常量池，方法区
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 */
public class ConstantPoolOOM {

    public static void main(String[] args) {

        /**
         * intern()是一个native方法，如果字符串常量池中已经包含了一个等于此String对象的字符串，则返回常量池中这个字符串的String对象
         * 否则，将此String对象包含的字符串添加到常量池中，返回此String对象的引用
         */
        String str1 = new StringBuffer("jisuanji").append("ruanjai").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuffer("ja").append("va").toString();
        System.out.println(str2.intern() == str2);

    }
}
