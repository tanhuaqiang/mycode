package com.dalingjia.LambdaStream;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedTest {


    @Test
    public void sortedTest(){

        List<Order> list = Lists.newArrayList();
        list.add(new Order(1, "xige", 2));
        list.add(new Order(2, "thq", 2));
        list.add(new Order(3, "thq", 4));
        list.add(new Order(4, "maoge", 3));
        list.add(new Order(5, "fangliang", 1));
        list.add(new Order(6, "thq", 2));
        //先根据sort进行排序，其次是orderName
        list.sort(Comparator.comparing(Order::getSort).thenComparing(Order::getOrderName).thenComparing(Order::getOrderId));

//        list.sort((l,r) -> {
//            if (l.getSort() == r.getSort()){
//                return l.getOrderName().compareTo(r.getOrderName());
//            } else {
//                return l.getSort() - r.getSort();
//            }
//        });
        //map转换作用
        System.out.println(list.stream().map(Order::getOrderId).collect(Collectors.toList()));

    }
}
