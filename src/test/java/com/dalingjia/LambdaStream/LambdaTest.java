package com.dalingjia.LambdaStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LambdaTest {

    private static List<String> articles = null;

    private static void addArticles(){
        articles = new ArrayList<String>();
        articles.add("Chinese");
        articles.add("Math");
        articles.add("English");
    }

    public static void main(String[] args) {
        addArticles();
        /*
            Optional是Java8新加入的一个容器，这个容器只存1个或0个元素，它用于防止出现NullpointException，它提供如下方法：
                isPresent() :                   判断容器中是否有值。
                ifPresent(Consume lambda) :     容器若不为空则执行括号中的Lambda表达式。
                T get() :                       获取容器中的元素，若容器为空则抛出NoSuchElement异常。
                T orElse(T other) :             获取容器中的元素，若容器为空则返回括号中的默认值。
         */
        //article代表集合中的元素，可以随便取名
        Optional<String> opt = articles.stream().filter(article -> article.contains("Mat")).findFirst();
        opt.ifPresent(article -> System.out.println(article));
//        System.out.println("****" + opt.get()); //容器为空，抛出NoSuchElementException
        System.out.println("---" + opt.orElse("tanhq"));
        System.out.println("=======================");

        List<Order> orderList = new ArrayList<Order>();
        orderList.add(new Order(1, "apple"));
        orderList.add(new Order(2, "banana"));
        orderList.add(new Order(3, "orange"));

        /*
         *Stream<T> filter(Predicate<? super T> predicate);
         */
        //filter接收predicate函数, predicate是接收T值,返回boolean值, 那么对应的引用就可以写成如下形式, 意思是取集合中不等于2的元素
        // map的作用就很明显是转换用的,
        List<Integer> newOrderIdList = orderList.stream()
                .filter(order -> order.getOrderId() != 2) //取满足过滤条件的
                //下面两种写法二者等价
//                .map(Order::getOrderId)           //JDK8中有双冒号的用法，就是把方法当做参数传到stream内部，使stream的每个元素都传入到该方法里面执行一下。
                .map(order -> order.getOrderId())   //JDK8中有双冒号的用法，就是把方法当做参数传到stream内部，使stream的每个元素都传入到该方法里面执行一下。
                .collect(Collectors.toList());
        newOrderIdList.stream().forEach(id -> System.out.println(id));

        System.out.println("***********************************");
        /**
         * <R> Stream<R> map(Function<? super T, ? extends R> mapper);
         * map操作接收的是Function接口,对于Function接收T值返回R值,那map的作用就很明显是转换用的,
         * 比如下面代码,转换名称为对应的名称长度,也就是从输入String数据返回int数据.
         * testData.LambdaStream().map(x -> x.length())
         */
        // map的作用就很明显是转换用的,
        /**
         * 这种[方法引用]或者说[双冒号运算]对应的参数类型是Function<T,R> T表示传入类型，R表示返回类型。
         * 比如表达式person -> person.getAge(); 传入参数是person，返回值是person.getAge()，那么方法引用Person::getAge就对应着Function<WxUser,Integer>类型。
         */
        List<String> newOrderNameList = orderList.stream()
                .filter(order -> order.getOrderId() != 1)
                .map(Order::getOrderName)//JDK8中有双冒号的用法，就是把方法当做参数传到stream内部，使stream的每个元素都传入到该方法里面执行一下。
                .collect(Collectors.toList());
        newOrderNameList.stream().forEach(name -> System.out.println(name));
        System.out.println(newOrderNameList);

    }

}