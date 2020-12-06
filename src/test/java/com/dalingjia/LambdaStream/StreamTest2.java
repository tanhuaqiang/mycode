package com.dalingjia.LambdaStream;

import com.dalingjia.Json.Person;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.summingInt;

/**
 * @author : tanhq
 * @version :
 * @date : Created in 2020/4/28 下午8:52
 * @description:
 */
public class StreamTest2 {

    /**
     * https://www.jianshu.com/p/e429c517e9cb
     * @param args
     */
    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();
        list.add(new Person("jack", 20));
        list.add(new Person("mike", 25));
        list.add(new Person("tom", 30));

        /**
         * int sum = list.stream().map(Person::getAge).reduce(0, Integer::sum);
         * 计算元素总和的方法其中暗含了装箱成本，map(Person::getAge) 方法过后流变成了 Stream<Integer> 类型，
         * 而每个 Integer 都要拆箱成一个原始类型再进行 sum 方法求和，这样大大影响了效率
         * 针对这个问题 Java 8 有良心地引入了数值流 IntStream, DoubleStream, LongStream，
         * 这种流中的元素都是原始数据类型，分别是 int，double，long
         *
         * 1. 流与数值流的转换
         * mapToInt(T -> int) : return IntStream
         * mapToDouble(T -> double) : return DoubleStream
         * mapToLong(T -> long) : return LongStream
         */
        IntStream intStream = list.stream().mapToInt(Person::getAge);
        //数值流转换为流
        Stream<Integer> stream = intStream.boxed();

        /**
         * 2. 数值流的方法
         * sum()
         * max()
         * min()
         * average() 等...
         */

        /**
         * 3. 数值范围, 一个是闭区间，一个是半开半闭区间：
         * rangeClosed(1, 100) ：[1, 100]
         * range(1, 100) ：[1, 100)
         */
        //求 1 到 10 的数值总和：
        IntStream intStream2 = IntStream.rangeClosed(1, 100);
        int sum = intStream2.sum();
        System.out.println(sum);


        /**
         * 4, 构建流
         */
        Stream<String> stringStream = Stream.of("aaa", "bbb", "ccc");

        /**
         * 5, 数组创建流
         * Arrays.stream(T[ ])
         * Arrays.stream(int[ ])
         * Arrays.stream(double[ ])
         * Arrays.stream(long[ ])
         */
        Stream<Integer> integerStream = Arrays.stream(new Integer[]{1, 2, 3, 4});

        /**
         * 6, 文件生成流
         * 每个元素是给定文件的其中一行
         */
//        try {
//            Stream<String> stream2 = Files.lines(Paths.get("data.txt"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        /**
         * 7, collect 方法作为终端操作，接受的是一个 Collector 接口参数，能对数据进行一些收集归总操作,
         *      最常用的方法，把流中所有元素收集到一个 List, Set 或 Collection 中
         * toList
         * toSet
         * toCollection
         * toMap
         */
        List newList = list.stream().collect(Collectors.toList());
        list.stream().collect(Collectors.toMap(Person::getAge, Function.identity()));

        /**
         * 8, 汇总，计算年龄总和
         */
        int ageSum = list.stream().mapToInt(Person::getAge).sum();
        int max1 = list.stream().mapToInt(Person::getAge).max().getAsInt();
        int min1 = list.stream().mapToInt(Person::getAge).min().getAsInt();

        /**
         * 9, 求平均值
         */
        Double average = list.stream().collect(Collectors.averagingInt(Person::getAge));
        OptionalDouble optionalDouble = list.stream().mapToInt(Person::getAge).average();
        double asDouble = optionalDouble.getAsDouble();

        /**
         * 10, 求最大值，最小值
         */
        Optional<Person> person = list.stream().max(Comparator.comparing(Person::getAge));
        Integer max = list.stream().map(Person::getAge).reduce(0, Integer::max);
        Integer min = list.stream().map(Person::getAge).reduce(0, Integer::min);

        /**
         * 11， joining 连接字符串
         */
        String collect = list.stream().map(Person::getName).collect(Collectors.joining(","));

        //结果：Today jack and mike and tom play games.
        String result = list.stream().map(Person::getName).collect(Collectors.joining(" and ", "Today ", " play games."));
        System.out.println("result=" + result);

        /**
         * 12, groupingBy 分组
         * 以下例子按年龄分组，Person::getAge 决定 Map 的键（Integer 类型），list 类型决定 Map 的值（List<Person> 类型）
         */
        Map<Integer, List<Person>> map = list.stream().collect(Collectors.groupingBy(Person::getAge));

        /**
         * 该例子中，我们通过年龄进行分组，然后 summingInt(Person::getAge)) 分别计算每一组的年龄总和（Integer），最终返回一个 Map<Integer, Integer>
         */
        Map<Integer, Integer> integerMap = list.stream().collect(Collectors.groupingBy(Person::getAge, summingInt(Person::getAge)));

        /**
         * 13, partitioningBy 分区
         * 分区与分组的区别在于，分区是按照 true 和 false 来分的，因此partitioningBy 接受的参数的 lambda 也是 T -> boolean
         */
        Map<Boolean, List<Person>> booleanListMap = list.stream().collect(Collectors.partitioningBy(p -> p.getAge() <= 20));
        System.out.println(booleanListMap);

    }
}
