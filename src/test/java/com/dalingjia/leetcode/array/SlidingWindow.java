package com.dalingjia.leetcode.array;

import com.google.common.collect.Lists;

import java.util.List;

public class SlidingWindow {

    private static List<Integer> slidingWindow(int[] array, int size){
        //滑动窗口里数值最大值组成的集合
        int length = array.length - size + 1;
        List<Integer> list = Lists.newArrayListWithCapacity(length);
        if(array==null||array.length<1||array.length<size||size<1){
            return list;
        }
        for (int i = 0; i < length ; i++) {
            list.add(slidingWindowMax(array, i, size));
        }
        return list;
    }

    private static int slidingWindowMax(int[] array, int start, int size) {
        int temp = array[start];
        for (int i = start; i < start + size ; i++) {
            if(temp < array[i]){
                temp = array[i];
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] array = {2,3,4,2,6,2,5,1};
        int size = 3;
        List<Integer> list = slidingWindow(array, size);
        list.stream().forEach(x -> System.out.print(x + ","));
    }

}
