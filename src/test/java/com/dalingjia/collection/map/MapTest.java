package com.dalingjia.collection.map;

import com.dalingjia.bean.ShipRule;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.*;

public class MapTest {

	public static void main(String[] args) {
		Map<String,String> map= new HashMap<String,String>();
		Map<String,String> map2= new Hashtable<String,String>();
		map.put("cs", "fsfs");
		map.put("cs", "sssss");
		for(Map.Entry<String, String> entry : map.entrySet()){
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}


	@Test
	public void test(){
		List<ShipRule> list = new ArrayList<ShipRule>();
		try {
			Map<Long, ShipRule> map = Maps.newHashMap();
			map.put(1L, new ShipRule(1L,"满500减10", "10"));
			map.put(2L, new ShipRule(2L,"满800减20", "20"));
			map.put(3L, new ShipRule(3L,"满1000减50", "50"));
			//map.entrySet()返回的是此映射中包含的映射关系的Set视图：Map.Entry<Long,ShipRule>键值对
			Set<Map.Entry<Long, ShipRule>> set = map.entrySet();
			//遍历Map.Entry<Long, ShipRule>实体
			map.entrySet().stream().forEach(x -> list.add(x.getValue()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void test2(){
		new HashMap<String, String>()
			{
				{
					put("img", null);
				}
			};

	}
}
