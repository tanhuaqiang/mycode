package com.dalingjia.leetcode.queue;

import java.util.PriorityQueue;

/**
 * @author tanhq
 * @Description 构建一个从大到小的优先队列
 * @Date 2019/11/24 上午11:51
 * @Version 1.0
 **/
public class MaxPriorityQueue {

    public static void main(String[] args) {
        PriorityQueue<String> q = new PriorityQueue<String>((a, b) -> (b.compareTo(a)));
        //入列
        q.offer("1");
        q.offer("2");
        q.offer("5");
        q.offer("3");
        q.offer("4");

        //出列
        System.out.println(q.poll());  //5
        System.out.println(q.poll());  //4
        System.out.println(q.poll());  //3
        System.out.println(q.poll());  //2
        System.out.println(q.poll());  //1
        String s1 = "ab";
        String b2 = "a" + "b";
        System.out.print(s1 == b2);
    }
}

 
    
    
    
    