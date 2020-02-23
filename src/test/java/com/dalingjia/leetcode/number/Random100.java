package com.dalingjia.leetcode.number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Random100 {

    private static int range = 100;
    private static ArrayList<Integer> originalList = new ArrayList<Integer>();
    private static ArrayList<Integer> result = new ArrayList<Integer>();

    static {
        for (int i = 1; i <= range; i++) {
            originalList.add(i);
        }
    }

    public static void main(String args[]) {
        for (int i = 0; i < range; i++) {
            int j = range - i;
            int r = new Random().nextInt(j);//生成[0~j)之间的随机int值

            result.add(originalList.get(r));//每次从[0,j)下标取一个值

            System.out.print(originalList.get(r) + ", ");
            originalList.remove(r);
        }

        Collections.sort(result);
        System.out.println("\n\n生成的数组大小是：" + result.size() + "------以下是排序结果，看是否有重复的随机数");
        for (Integer i : result) {
            System.out.print(i + ", ");
        }
    }
}