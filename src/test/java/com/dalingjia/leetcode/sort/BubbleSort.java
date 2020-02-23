package com.dalingjia.leetcode.sort;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/*
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        Integer[] arr = {8, 9, 1, 2, 3, 6};
        int count = 0; //记录总共的趟数
        boolean flag;
        System.out.println("排序前数组为：");
        Arrays.asList(arr).stream().forEach(integer -> System.out.print(integer));
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) { //总共要进行几趟排序
            flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) { //每趟需要交换的次数
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            count++;
            if (!flag) {
                break;  //如果一趟下来，元素没有交换，说明数组已经排好序
            }
        }
        System.out.println();
        System.out.println("排序后数组为：");
        Arrays.asList(arr).stream().forEach(integer -> System.out.print(integer));
        System.out.println();
        System.out.println("循环控制排序趟数: count=" + count);
    }


    @Test
    public void studentSort() {
        List<Student> list = Lists.newArrayList();
        list.add(new Student(23, "tanhq"));
        list.add(new Student(25, "dage"));
        list.add(new Student(24, "xige"));
        list.add(new Student(23, "jingling"));
        list.add(new Student(21, "jingling"));
        list.add(new Student(27, "bingge"));
        list.add(new Student(20, "zhanteng"));
        Student stu = new Student();
        boolean flag;
        for (int i = 0; i < list.size() - 1; i++) {
            flag = false;
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).getAge() > list.get(j + 1).getAge()) {
                    stu = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, stu);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        list.stream().forEach(student -> System.out.println(student.toString()));
        System.out.println("--------------------");
        list.forEach(student -> System.out.println(student.toString()));
    }

}