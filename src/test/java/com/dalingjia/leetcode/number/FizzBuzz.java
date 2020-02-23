package com.dalingjia.leetcode.number;

import java.util.*;

/**
 * @author tanhq
 * @Description   FizzBuzz
 * @Date 2019/8/22 下午7:41
 * @Version 1.0
 **/
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n ; i++) {
            if(i%3 == 0 && i%5==0){
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if(i % 5 == 0){
                list.add("Buzz");
            }else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }



}

 
    
    
    
    