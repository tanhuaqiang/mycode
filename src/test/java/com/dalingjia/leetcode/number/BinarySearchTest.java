package com.dalingjia.leetcode.number;

import java.util.Arrays;

public class BinarySearchTest {

	public static void main(String[] args) {
		int[] arr = {1,4,7,24,67,94};
		int key  = binarySearch0(arr, 1, arr.length, 3);
		System.out.println("key="+key);
		System.out.println(Arrays.binarySearch(arr, 1, arr.length, 3));
		
	}
	/**
	 * 在进行此调用之前，必须根据元素的自然顺序对范围进行升序排序
	 * 使用二分搜索法来搜索指定数组的范围，以获得指定对象
	 * 如果范围包含多个等于指定对象的元素，则无法保证找到的是哪一个
	 * @param a  要搜索的数组
	 * @param fromIndex  要搜索的第一个元素的索引（包括）
	 * @param toIndex 要搜索的最后一个元素的索引（不包括）
	 * @param key  要搜索的值 
	 * @return
	 */
	private static int binarySearch0(int[] a, int fromIndex, int toIndex, int key) {
		int low = fromIndex;
		int high = toIndex - 1;
		
		while (low <= high) {
			int mid = (low + high) >>> 1;
			int midVal = a[mid];
			
			if (midVal < key)
			low = mid + 1;
			else if (
					midVal > key)
			high = mid - 1;
			else
			return mid; // key found
		}
		return -(low + 1);  // key not found.
	}
}
