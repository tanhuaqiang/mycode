package com.dalingjia.collection.set;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;

public class LinkedHashSetTest {

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("java", "golang", "python" , "ruby", "scala", "c");
        System.out.println("list:" + list);

        //1,HashSet
        Set<String> stringSet = new HashSet<String>(list);
        System.out.println("HashSet:" + stringSet);

        //2,HashMap
        Map<String, Object> map = Maps.newHashMap();
        Object object = new Object();
        map.put("java", object);
        map.put("golang", object);
        map.put("python", object);
        map.put("ruby", object);
        map.put("scala", object);
        map.put("c", object);
        System.out.println("map:" + map);

        //3,LinkedHashSet内部使用的是LinkHashMap, 这样做的意义或者好处就是LinkedHashSet中的元素顺序是可以保证的，也就是说遍历序和插入序是一致的。
        HashSet set = new LinkedHashSet(list);
        System.out.println("LinkedHashSet:" + set);

        //4,LinkedHashMap
        HashMap<String, Object> hashMap = new LinkedHashMap<>();
        hashMap.put("java", object);
        hashMap.put("golang", object);
        hashMap.put("python", object);
        hashMap.put("ruby", object);
        hashMap.put("scala", object);
        hashMap.put("c", object);
        System.out.println("LinkedHashMap:" + hashMap);
    }
}
