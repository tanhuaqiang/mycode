package com.dalingjia.leetcode.string;

import java.util.*;

/**
 * @author tanhq
 * @Description  929 独特的电子邮件地址
 * @Date 2019/9/18 下午5:09
 * @Version 1.0
 **/
public class NumUniqueEmails {

    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String s : emails) {
            String[] str = s.split("@");
            str[0] = str[0].replaceAll("\\.", "");
            int index = str[0].indexOf("+");
            if (index > 0) {
                str[0] = str[0].substring(0, index);
            }
            set.add(str[0] + "@" + str[1]);
        }
        return set.size();
    }

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
    }
}

 
    
    
    
    