package com.dalingjia.LambdaStream;

import org.junit.Test;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author : tanhq
 * @version :
 * @date : Created in 2020/7/22 下午5:02
 * @description:
 */
public class ConsumerTest {


    @Test
    public void test111() {
        int i = 27;
        //方法引用作为consumer；方法引用是java8的新特性之一， 可以直接引用已有Java类或对象的方法或构造器
        //https://www.jianshu.com/p/62465b26818f#fnref4
        Consumer consumer = this::addMethod;
        //调用accept方法相当于addMethod方法
        consumer.accept(i);
    }

    private void addMethod(Object o) {

        System.out.println("o = " + o);
    }


}
