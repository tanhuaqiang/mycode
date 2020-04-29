package com.dalingjia.LambdaStream;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author : tanhq
 * @version :
 * @date : Created in 2020/4/27 下午11:57
 * @description:
 */
public class ReduceTest {

    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});

        //求集合元素之和
        Integer result = stream.reduce(0, Integer::sum);
        System.out.println(result);

        stream = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7).stream();

        //求和
        Integer sum = stream.reduce((i, j) -> i + j).orElse(0);
        System.out.println("sum=" + sum);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        //求最大值
        stream.reduce(Integer::max).ifPresent(System.out::println);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        //求最小值
        stream.reduce(Integer::min).ifPresent(System.out::println);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        //做逻辑
        stream.reduce((i, j) -> i > j ? j : i).ifPresent(System.out::println);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});

        //求逻辑求乘机
        int result2 = stream.filter(i -> i % 2 == 0).reduce(1, (i, j) -> i * j);

        Optional.of(result2).ifPresent(System.out::println);
    }
}
