package com.dalingjia.leetcode.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * a[i][j] = a[i-1][j-1] + a[i-1][j];
 */
public class YangHuiTriangle {

    //打印杨辉三角
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangleList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i){
                    list.add(1);
                }else {
                    list.add(triangleList.get(i-1).get(j) + triangleList.get(i-1).get(j-1));
                }
            }
            triangleList.add(list);
        }
        return triangleList;
    }

    //打印杨辉三角第n行
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex + 1);
        list.add(1);//第0行
        if(rowIndex == 0){
            return list;
        }
        list.add(1);//第1行
        if(rowIndex == 1){
            return list;
        }
        for (int i = 2; i <= rowIndex ; i++) {
            //外层循环加1操作
            list.add(1);
            for (int j = i - 1; j > 0 ; j--) {
                //设置元素为上面的值 + 左上角的值
                list.set(j, list.get(j) + list.get(j - 1));
            }
        }
        return list;
    }

    @Test
    public void test() {
        generate(4);
        getRow(3);
    }





    public static void main(String[] args) {
        int rows = 10;

        for (int i = 0; i < rows; i++) {
            int number = 1;
            //打印空格字符串
            System.out.format("%" + (rows - i) * 2 + "s", "");
            for (int j = 0; j <= i; j++) {
                //%4d --- 以至少 4 位宽度显示一个整数， 如 _ _ _ 4
                System.out.format("%4d", number);
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
}
