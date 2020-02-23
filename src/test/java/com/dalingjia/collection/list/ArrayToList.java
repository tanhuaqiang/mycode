package com.dalingjia.collection.list;

import com.dalingjia.bean.WxUser;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToList {

	public static void main(String[] args) {
		//数组转换成集合，数组元素必须使用包装类
		Integer[] arr = {4,2,6,9,3,10};
		List<Integer> list = Arrays.asList(arr);
		for (Integer integer : list) {
			System.out.print(integer+"\t");
		}
		System.out.println();
		//集合转换成数组
		Integer[] arr2 = (Integer[]) list.toArray();
		System.out.println(Arrays.toString(arr2));
		
		//对数组arr2从小到大进行排序
		Arrays.sort(arr2);
		System.out.println(Arrays.toString(arr2));

		Object[] objects = {1, 2, 3, 4, 5, 6};
		//复制指定的数组，截取或用 0 填充（如有必要）
		objects = Arrays.copyOf(objects, 12);
		System.out.println(objects.length);
		System.out.println(Arrays.toString(objects));

	}


	@Test
	public void comparatorArray(){
		Integer[] integers = {4, 7, 2, 9, 16};
		/**
		 * 根据指定比较器产生的顺序对指定对象数组进行排序
		 */
		Arrays.sort(integers, (n1, n2) -> {
			return n1 - n2;
		});
		System.out.println(Arrays.toString(integers));


	}
}
