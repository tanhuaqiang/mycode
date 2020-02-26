package com.dalingjia.test;

import java.math.BigDecimal;
import com.dalingjia.LambdaStream.User;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

        List<User> list = new ArrayList<>();
        list.add(new com.dalingjia.LambdaStream.User(1, "tanhq", 23, new BigDecimal(40000), 3));
        list.add(new com.dalingjia.LambdaStream.User(2, "xiaohong", 33, new BigDecimal(20000), 2));
        list.add(new com.dalingjia.LambdaStream.User(3, "maoge", 26, new BigDecimal(10000), 3));
        list.add(new com.dalingjia.LambdaStream.User(4, "fanfan", 27, new BigDecimal(30000), 1));
        list.add(new com.dalingjia.LambdaStream.User(5, "laomao", 25, new BigDecimal(50000), 2));
        list.add(new com.dalingjia.LambdaStream.User(6, "lining", 26, new BigDecimal(60000), 2));
        list.stream().sorted(Comparator.comparing(User::getGrade));
        list.forEach(user -> System.out.println(user));
        System.out.println("=================");
        list.sort(Comparator.comparingInt(User::getAge));
        list.forEach(user -> System.out.println(user));
        System.out.println("*********************");
        list.sort(Comparator.comparing(User::getAge).reversed());
        list.forEach(user -> System.out.println(user));
        System.out.println("&&&&&&&&&&&&&&&&&&&&");
        //reversed()方法放中间导致前面2个字段都是按照降序排序
        list.sort(Comparator.comparing(User::getAge).thenComparing(User::getGrade).reversed().thenComparing(User::getAccount));
        list.forEach(user -> System.out.println(user));
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

 
    
    
    
    