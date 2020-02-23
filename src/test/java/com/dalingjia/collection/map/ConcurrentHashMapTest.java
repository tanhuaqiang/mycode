package com.dalingjia.collection.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

    public static void main(String[] args) {

        //一个ConcurrentHashMap维护一个Segment数组，一个Segment维护一个HashEntry数组。
        ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<Object, Object>();
        map.put("cs", "fsfs");
        map.put("cs", "sssss");
        /**
         * 不允许null键和null值
         */
//		map.put(null, "aaa");
//		map.put(null, null);
        map.put("", "bbb");
		/*Set<String> set = map.keySet();
		for (String string : set) {
			System.out.println(map.get(string));
		}*/
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
        System.out.println(map.get("cs"));

        map.size();

    }

}
