package com.dalingjia;

import java.util.*;
import java.util.Scanner;

/**
 * @author tanhq
 * @Description TODO
 * @Date 2022/4/30 下午7:38
 * @Version 1.0
 * 有100(10人或者n个)个人围成一圈，从第一个人开始报数（报1、2、3），
 * 只要报3的人就出去， 然后不停的循环报数，直到最后剩下一个人，计算出这个人最开始的位置。
 **/
public class Main1 {

    public static void main(String[] args) {
        System.out.println(method(10));
        System.out.println(method(100));
        while (true) {
            System.out.println(3333);
        }
    }

    /**
     * @param n 总人数
     * @return
     */
    private static int method(int n) {
        int[] ints = new int[n];
        //初始化n个人
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i+1;
        }
        //用来计数1-3
        int temp = 0;
        //当前报数的人所处的位置
        int index = 0;
        //刚开始的总人数
        int people = n;
        while (people > 1) {
            //当前位置的人没有退出，进行报数
            if (ints[index] != 0) {
                temp++;
            }
            //报的数是3，进行退出
            if (temp == 3) {
                ints[index] = 0;//表示该位置的人已经退出
                people--; //人数减1
                temp = 0; //从新开始报数
            }
            index++;
            //一圈报完了，从头开始
            if (index == n) {
                index = 0;
            }
        }
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != 0) {
                return ints[i];
            }
        }
        return -1;
    }

}

 
    
    
    
    