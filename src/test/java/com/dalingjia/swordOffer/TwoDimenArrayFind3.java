package com.dalingjia.swordOffer;

public class TwoDimenArrayFind3 {

	/**
	 * 题目描述：在一个二维数组中，
	 * 		每一行都按照从左到右递增的顺序排序，
	 * 		每一列都按照从上到下的顺序排序。 
	 * 		完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否包含该整数;
	 * 
	 * 先定义一个二维数组 4*5,4行5列
	 * 1  3  5  8   9
	 * 2  5  9  11  17
	 * 4  8  10 18  22
	 * 6  9  18 24  38
	 */
	public static void main(String[] args) {
		/*int arr[][] = new int[4][5];
		arr[0][0] = 1; arr[0][1] = 3; arr[0][2] = 5; arr[0][3] = 8; arr[0][4] = 9;
		arr[1][0] = 2; arr[1][1] = 5; arr[1][2] = 9; arr[1][3] = 11; arr[1][4] = 17;
		arr[2][0] = 4; arr[2][1] = 8; arr[2][2] = 10; arr[2][3] = 22; arr[2][4] = 22;
		arr[3][0] = 6; arr[3][1] = 1; arr[3][2] = 18; arr[3][3] = 24; arr[3][4] = 38;*/
		int[][] arr = {
				{1 , 3 , 5 ,  8  , 9},
				{2 , 5 , 9 ,  11 , 17},
				{4 , 8 , 10 , 18 , 22},
				{6 , 9 , 18 , 24 , 38},
		};
		System.out.println(arr.length);
		System.out.println(arr[0].length);
		System.out.println(find(arr, 10));
		System.out.println(find(arr, 19));
	}
	
	/**
	 * 定义查找函数
	 */
	public static boolean find(int arr[][], int a){
		boolean flag = false;
		//获取数组的行和列
		int rows = arr.length;//行
		int cols = arr[0].length;//列
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (arr[i][j] == a) {
					flag = true;
					return flag;
				}
			}
		}
		return flag;
	}
}
