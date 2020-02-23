package com.dalingjia.leetcode.string;

import java.util.*;

/**
 * @author tanhq
 * @Description  1169 查询无效交易
 * @Date 2019/9/22 下午1:33
 * @Version 1.0
 **/
public class InvalidTransactions {

    /**
     * ["alice,20,800,mtv","alice,50,100,beijing"]
     * 1,交易金额超过 ¥1000
     * 2,或者，它和另一个城市中同名的另一笔交易相隔不超过 60 分钟（包含 60 分钟整）
     * @param transactions
     * @return
     */
    public List<String> invalidTransactions(String[] transactions) {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < transactions.length - 1; i++) {
            for (int j = i + 1; j < transactions.length; j++) {
                String[] str = transactions[i].split(",");
                String[] str2 = transactions[j].split(",");
                if (Integer.parseInt(str[2]) > 1000) {
                    set.add(transactions[i]);
                }
                if (Integer.parseInt(str2[2]) > 1000) {
                    set.add(transactions[j]);
                }
                if (str[0].equals(str2[0]) && !str[3].equals(str2[3])
                        && Math.abs(Integer.parseInt(str[1]) - Integer.parseInt(str2[1])) <= 60) {
                    set.add(transactions[i]);
                    set.add(transactions[j]);
                }
            }
        }
        for (String s : set) {
            list.add(s);
        }
        return list;
    }
}

 
    
    
    
    