package com.dalingjia.LambdaStream;

import java.util.Optional;

/**
 * @author : tanhq
 * @version :
 * @date : Created in 2020/2/24 下午2:39
 * @description:
 */
public class OptionalTest {

    /**
     * 参考链接：https://www.jianshu.com/p/47ba2853a125
     * Optional是Java8新加入的一个容器，这个容器只存1个或0个元素，它用于防止出现NullpointException，它提供如下方法：
     *      isPresent() :                   判断容器中是否有值。
     *      ifPresent(Consume lambda) :     容器若不为空则执行括号中的Lambda表达式。
     *      T get() :                       获取容器中的元素，若容器为空则抛出NoSuchElement异常。
     *      T orElse(T other) :             获取容器中的元素，若容器为空则返回括号中的默认值。
     */
    public static void main(String[] args) {
        /**
         * 1,Optional<T> empty() 生成一个空Optional对象，其value为null
         *
         * 2,Optional<T> of(T value) 调用Optional(T)构造方法，其value不允许为null
         *
         * 3,Optional<T> ofNullable(T value) 与Optional<T> of(T value)的差别是其传入的value允许为null
         */
        Optional<String> optional=Optional.of("aa");
        Optional<String> optionalResult=optional.filter(s -> s.startsWith("a"))
                .filter(s -> s.length()==2)
                .filter(s -> s.endsWith("a"));
        System.out.println(optionalResult);


        Optional<String> optional2=Optional.of("aa");
        Optional<Integer> result= optional2.map(s -> s.toUpperCase())
                .map(s->s.length());
        System.out.println(result.get());

        //orElse: 这个方法较为简单，参数为一个默认值，即若value为null，则返回默认值
        Optional<String> optional3=Optional.of("aa");
        System.out.println(optional3.orElse("bb"));
        Optional<String> optional4=Optional.ofNullable(null);
        System.out.println(optional4.orElse("bb"));


        System.out.println(Optional.ofNullable("").orElse("apple"));
    }
}
