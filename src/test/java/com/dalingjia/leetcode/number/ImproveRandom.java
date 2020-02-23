package com.dalingjia.leetcode.number;

import java.util.Random;

public class ImproveRandom {

    private static int total = 100;
    private static int[] result;

    private static int[] getResult(int total){
        int[] numberArray = new int[total];
        int[] returnArray = new int[total];

        //生成1-100的数组
        for (int i = 0; i <total ; i++) {
            numberArray[i] = i+1;
        }

        int rand = 0;
        int end = total -1; //获取数组最后一个元素的下标
        for (int i = 0; i < total; i++) {
            rand = new Random().nextInt(end+1);//随机生成[0~100)之间的数
            returnArray[i] = numberArray[rand];//将rand对应的下标的数添加到returnArray
            /*
            * 节省空间和内存
            * 用最后一个end下标对应的数替换放入到returnArray数组中的值，
            * 避免该数再次被放入returnArray
            */
            numberArray[rand] = numberArray[end];
            end--;

        }
        return returnArray;
    }

    public static void main(String[] args) {
        result = getResult(total);
        for (int i = 0; i < total; i++) {
            System.out.print(result[i]+"\t");
        }

    }
}