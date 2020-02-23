package com.dalingjia.test;

import com.daling.bean.User;
import com.dalingjia.leetcode.ListNode.ListNode;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.concurrent.locks.LockSupport;

/**
 * @author tanhq
 * @Description
 * @Date 2019/10/9 下午12:26
 * @Version 1.0
 **/
public class AAA {


    public static void main(String[] args) {
        String s = "abc";
        byte[] bytes = s.getBytes();
        System.out.println(bytes);
        System.out.println(bytes[0]);
        int[] arr = {3, 6, 9, 27, 8};
        System.out.println(getPyramidSum(arr));
    }

    private static int getPyramidSum(int[] arr) {
        int len = arr.length - 1;
        for (int i = len; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                arr[j] = arr[j] + arr[j + 1];
            }
        }
        return arr[0];
    }

}

 
    
    
    
    