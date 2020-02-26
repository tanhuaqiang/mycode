package com.dalingjia.LambdaStream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author tanhq
 * @Description java 8 lambda表达式 list操作：转map，分组、过滤、求和、最值、排序、去重
 * @Date 2019/11/23 下午2:11
 * @Version 1.0
 **/
public class ListOperator {

    private static List<User> list = new ArrayList<>();

    private static void addArticles() {
        list.add(new User(1, "tanhq", 23, new BigDecimal(40000), 3));
        list.add(new User(2, "xiaohong", 33, new BigDecimal(20000), 2));
        list.add(new User(3, "maoge", 26, new BigDecimal(10000), 3));
        list.add(new User(4, "fanfan", 27, new BigDecimal(30000), 1));
        list.add(new User(5, "laomao", 25, new BigDecimal(50000), 2));
        list.add(new User(6, "lining", 26, new BigDecimal(60000), 2));
        list.addAll(new ArrayList<>());
    }

    public static void main(String[] args) {
        addArticles();
        //1,list转map
        Map<Integer, String> map = list.stream().collect(Collectors.toMap(User::getId, User::getName));
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "---" + entry.getValue());
        }

        Map<Integer, User> map2 = list.stream().collect(Collectors.toMap(User::getId, a -> a));
        for (Map.Entry<Integer, User> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + "---" + entry.getValue());
        }
        /**
         * List -> Map
         * 需要注意的是：
         * toMap 如果集合对象有重复的key，会报错Duplicate key ....
         *  User1,User2的id都为1。
         *  可以用 (u1, u2) -> u1 来设置，如果有重复的key,则保留key1,舍弃key2
         */
        Map<Integer, User> map3 = list.stream().collect(Collectors.toMap(User::getId, user -> user, (u1, u2) -> u1));
        for (Map.Entry<Integer, User> entry : map3.entrySet()) {
            System.out.println(entry.getKey() + "---" + entry.getValue());
        }

//        list = new ArrayList<>();
        //2,list分组
        Map<Integer, List<User>> groupByGrade = list.stream().collect(Collectors.groupingBy(User::getGrade));
        for (Map.Entry<Integer, List<User>> entry : groupByGrade.entrySet()) {
            System.out.println(entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println(user.toString());
            }
        }

        List<List<User>> mapTo = groupByGrade.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());
        System.out.println(mapTo);

        //3,list过滤
        List<User> filterList = list.stream()
                .filter(user -> !user.getName().equals("xiaohong"))
                .filter(user -> user.getAge()!=27)
                .collect(Collectors.toList());
        filterList.stream().forEach(user -> System.out.println("filterList：" + user.toString()));

        //4,list求和
        //a,基本类型求和
        int sum = list.stream().mapToInt(User::getAge).sum();
        System.out.println("sum=" + sum);
        //b,大数类型求和
        BigDecimal result = list.stream().map(user -> user.getAccount()).reduce(BigDecimal.ZERO, BigDecimal::add);

        //5,list最值
        Integer minAge = list.stream().map(User::getAge).min(Integer::compareTo).get();
        Integer maxAge = list.stream().map(user -> user.getAge()).max(Integer::compareTo).get();

        //6,list排序,多字段排序，//reversed() 方法放中间导致前面2个字段都是按照降序排序
        //参考链接：https://www.cnblogs.com/liululee/p/10935244.html
        list.sort(Comparator.comparing(User::getAge).thenComparing(User::getGrade).reversed().thenComparing(User::getAccount));
        list.stream().forEach(user -> System.out.println(user));
        System.out.println("***********************");

        //7,list去重
        List<Integer> idList = new ArrayList<Integer>();
        idList.add(1);
        idList.add(1);
        idList.add(2);
        List<Integer> distinctIdList = idList.stream().distinct().collect(Collectors.toList());


        //8, map转list
        List<User> mapToList = map3.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());
        System.out.println(mapToList);
        System.out.println("------------------");
        //按照年龄升序
        list.sort(Comparator.comparingInt(User::getAge));
        list.stream().forEach(user -> System.out.println(user));
    }
}

 
    
    
    
    