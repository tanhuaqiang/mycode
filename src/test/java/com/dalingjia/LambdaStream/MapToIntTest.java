package com.dalingjia.LambdaStream;

import java.util.Arrays;
import java.util.List;

/**
 * @author : tanhq
 * @version :
 * @date : Created in 2020/4/28 下午7:56
 * @description:
 */
public class MapToIntTest {

    /**
     * https://www.jianshu.com/p/0bb4daf6c800
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        int sum1 = list.stream().reduce(0, (a, b) -> a + b).intValue();
        int sum2 = list.stream().mapToInt(e -> e).sum();
        System.out.println(sum1 + " " + sum2);
    }
}
