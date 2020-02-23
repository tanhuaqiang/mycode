package com.dalingjia.annotation;

import java.lang.annotation.*;

/**
 * @author  tanhq
 * @Date 2018/10/30
 */
@Target(ElementType.METHOD)         //作用：用于描述注解的使用范围（即：被描述的注解可以用在什么地方）
@Retention(RetentionPolicy.RUNTIME) //作用：表示需要在什么级别保存该注释信息，用于描述注解的生命周期（即：被描述的注解在什么范围内有效）
@Documented
public @interface MyAnnotation {

    String hello() default "hello";
    String world();
}
