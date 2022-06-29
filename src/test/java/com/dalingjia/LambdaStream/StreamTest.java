package com.dalingjia.LambdaStream;

import com.dalingjia.Json.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : tanhq
 * @version :
 * @date : Created in 2020/4/28 下午8:12
 * @description:
 */
public class StreamTest {

    /**
     * https://www.jianshu.com/p/0bb4daf6c800
     * @param args
     */
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("jack", 20));
        list.add(new Person("mike", 25));
        list.add(new Person("tom", 30));

        //1. stream() / parallelStream(),将集合转换为流

        //2. filter(T -> boolean), 保留boolean为true的元素

        //3. distinct(),去除重复元素，这个方法是通过类的 equals 方法来判断两个元素是否相等的

        //4. sorted() / sorted((T, T) -> int), 如果流中的元素的类实现了 Comparable 接口，即有自己的排序规则，那么可以直接调用 sorted() 方法对元素进行排序，如 Stream<Integer>；
        // 反之, 需要调用 sorted((T, T) -> int) 实现 Comparator 接口

        //5. limit(long n),返回前 n 个元素

        //6. skip(long n), 去除前 n 个元素

        //7. map(T -> R), 将流中的每一个元素T映射为R（类似于类型转换）

        //8. flatMap(T -> Stream<R>), 将流中的每一个元素T映射为一个流，再把每一个流连接成为一个流
        List<String> list2 = new ArrayList<>();
        list2.add("aaa   bbb ccc");
        list2.add("ddd eee   fff");
        list2.add("ggg hhh iii");
        list2 = list2.stream().map(s -> s.split("\\s+")).flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println(list2);

        //9. anyMatch(T -> boolean),流中是否有一个元素匹配给定的 T -> boolean 条件
        boolean bool = list.stream().anyMatch(person -> person.getId() == 20);

        //10. allMatch(T -> boolean), 流中是否所有元素都匹配给定的 T -> boolean 条件

        //11. noneMatch(T -> boolean), 流中是否没有元素匹配给定的 T -> boolean 条件

        //12. findAny() 和 findFirst(),findAny()：找到其中一个元素 （使用 stream() 时找到的是第一个元素；使用 parallelStream() 并行时找到的是其中一个元素）
        //findFirst()：找到第一个元素, 返回一个Optional<T> 对象，它是一个容器类，能代表一个值存在或不存在

        /**
         * 13. reduce((T, T) -> T) 和 reduce(T, (T, T) -> T),用于组合流中的元素，如求和，求积，求最大值等
         * 其中，reduce第一个参数0代表起始值为0，lambda: (a,b) -> a + b 即将2值相加产生一个新值
         *
         * Integer::sum 等价于 (a, b) -> a + b
         */
        int sum = list.stream().map(Person::getAge).reduce(0, (a, b) -> a + b);
        int sum2 = list.stream().map(Person::getAge).reduce(0, Integer::sum);
        System.out.println(sum + "==" + sum2);
        /**
         * 14. count()，返回流中元素个数，结果为long类型
         */

        /**
         * 15. collect()，收集方法，我们很常用的是collect(Collectors.toList())，当然还有 collect(Collectors.toSet()) 等，参数是一个收集器接口
         */
        //Array转list
        Integer[] arr = {2, 0, 4, 9, 3, 6, 8, 7, 1, 5, 3};
        List<Integer> collect = Arrays.stream(arr).collect(Collectors.toList());
        collect.forEach(System.out::println);

        //list转array
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("q");
        list1.add("t");
        list1.add("e");
        String[] strings = new String[list1.size()];
        String[] strings1 = list1.toArray(strings);
        System.out.println(Arrays.toString(strings1));

    }
}
