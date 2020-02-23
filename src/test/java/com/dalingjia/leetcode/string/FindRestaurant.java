package com.dalingjia.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanhq
 * @Description 599 两个列表的最小索引总和
 * @Date 2019/9/7 下午5:16
 * @Version 1.0
 **/
public class FindRestaurant {

    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> list = new ArrayList<>();
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if (i + j < minIndex) {
                        list.clear();
                        list.add(list1[i]);
                        minIndex = i + j;
                    } else if (i + j == minIndex) {
                        list.add(list1[i]);
                    }
                    break;
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }
}

 
    
    
    
    