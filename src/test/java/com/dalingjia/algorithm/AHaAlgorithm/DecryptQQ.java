package com.dalingjia.algorithm.AHaAlgorithm;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecryptQQ {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("631758924");
        StringBuffer stringBuffer = new StringBuffer();
        while (sb.length()>0){
            stringBuffer.append(sb.charAt(0));
            sb.deleteCharAt(0);
            if(sb.length()>0){
                sb.append(sb.charAt(0));
                sb.deleteCharAt(0);
            }
        }
        System.out.println(stringBuffer.toString());
    }

    @Test
    public void test1(){
        Deque<String> queue = new ArrayDeque<String>();
        StringBuffer stringBuffer = new StringBuffer();
        queue.offer("6");
        queue.offer("3");
        queue.offer("1");
        queue.offer("7");
        queue.offer("5");
        queue.offer("8");
        queue.offer("9");
        queue.offer("2");
        queue.offer("4");
        System.out.println(queue);
        while (!queue.isEmpty()){
//            queue.peek();//取出元素，并不删除
            stringBuffer.append(queue.poll());
            if(!queue.isEmpty()){
                queue.offer(queue.poll());
            }
        }
        System.out.println(stringBuffer.toString());
    }
}
