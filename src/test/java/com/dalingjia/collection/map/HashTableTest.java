package com.dalingjia.collection.map;

import java.util.Hashtable;
import java.util.Map;

public class HashTableTest {

	public static void main(String[] args) {
		Hashtable<Object,Object> map= new Hashtable<Object,Object>();
		map.put("ffa", "ftge");
		map.put("cs", "fsfs");
		map.put("cs", "sssss");
		map.get("cs");
		
		//map.put(null, null);//java.lang.NullPointerException
//		map.put(null, "faf");//java.lang.NullPointerException
		//map.put("aa", null);//java.lang.NullPointerException
		
		
		/*Set<String> set = map.keySet();
		for (String string : set) {
			System.out.println(map.get(string));
		}*/
		for(Map.Entry<Object, Object> entry : map.entrySet()){
			System.out.println(entry.getKey()+"\t"+entry.getValue());
		}
	}
}
