package com.dalingjia.LambdaStream;

import com.dalingjia.bean.WxUser;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MatchTest {

    @Test
    public void anyMatchTest() {
        List<WxUser> list = new ArrayList<WxUser>();
        list.add(new WxUser(1, "tanhq", 25, false));
        list.add(new WxUser(2, "fangliang", 25, false));
        list.add(new WxUser(3, "laomao", 24, true));
        list.add(new WxUser(4, "dage", 24, false));

        //检查谓词是否至少匹配一个元素,只要有一个为true，就返回true
        boolean result = list.stream().anyMatch(WxUser::isHZ);
        System.out.println(result);
    }

    @Test
    public void convertTest() {
        List<String> collected = new ArrayList<>();
        collected.add("alpha");
        collected.add("beta");
        //map映射，全部转换成大写
        collected = collected.stream().map(string -> string.toUpperCase()).collect(Collectors.toList());
        System.out.println(collected);
    }

    @Test
    public void convertTest2() {
        List<String> collected = new ArrayList<>();
        collected.add("alpha");
        collected.add("beta");
        //双冒号写法，两种不同的写法
        collected = collected.stream().map(String::toUpperCase).collect(Collectors.toList());//注意写法发生的变化
        System.out.println(collected);

                                                                                    //对象::方法名
        collected = collected.stream().map(String::toUpperCase).collect(Collectors.toCollection(ArrayList::new));//注意发生的变化
        System.out.println(collected);

    }

    @Test
    public void test1(){
        List<WxUser> list = new ArrayList<WxUser>();
        list.add(new WxUser(1, "tanhq", 25, false));
        list.add(new WxUser(2, "fangliang", 25, true));
        list.add(new WxUser(3, "laomao", 24, false));
        list.add(new WxUser(4, "dage", 24, false));
        //map转换作用
        String ids = list.stream().map(x -> x.getId().toString()).collect(Collectors.joining("%"));
        String ids2 = list.stream().map(x -> x.getId().toString()).collect(Collectors.joining("-"));
        List<Integer> ids3 = list.stream().map(x -> x.getId()).collect(Collectors.toList());
        System.out.println(ids);
        System.out.println(ids2);
        System.out.println(ids3);
    }
}
