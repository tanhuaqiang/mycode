package com.dalingjia.algorithm.AHaAlgorithm;

import java.util.ArrayDeque;
import java.util.Arrays;

public class CatFishing {

    public static String[] catFishingUtil(ArrayDeque<String> arrayDequeA, ArrayDeque<String> arrayDequeB){
        //桌面的牌
        ArrayDeque stack = new ArrayDeque();
        //临时收起的牌
        StringBuilder temp = new StringBuilder();
        String dequeA = "";
        String dequeB = "";
        //初始化10个令牌桶
        int[] arr = new int[10];
        String[] result = new String[3];
        while (!arrayDequeA.isEmpty() && !arrayDequeB.isEmpty()){
            //A先出牌
            if(!arrayDequeB.isEmpty()){
                dequeA = arrayDequeA.poll();
                ////若A出的牌和桌上的牌不相同
                if(arr[Integer.parseInt(dequeA)] == 0) {
                    stack.push(dequeA);
                    arr[Integer.parseInt(dequeA)] = 1;
                }else { //若A出的牌和桌上的某张牌相同，A收牌，将牌放队列尾部
                    arrayDequeA.offer(dequeA);
                    while (!dequeA.equals(stack.peek())){
                        arr[Integer.parseInt(stack.peek().toString())] = 0; //令牌桶元素清空
                        arrayDequeA.offer(stack.pop().toString());
                    }
                    arr[Integer.parseInt(stack.peek().toString())] = 0; //令牌桶元素清空
                    arrayDequeA.offer(stack.pop().toString());
                }
            }


            //B出牌，若A手中没牌了，就不出牌了
            if(!arrayDequeA.isEmpty()){
                dequeB = arrayDequeB.poll();
                //若B出的牌和桌上牌不相同
                if(arr[Integer.parseInt(dequeB)] ==0){
                    stack.push(dequeB);
                    arr[Integer.parseInt(dequeB)] = 1;
                }else { //若B出的牌和桌上牌相同的，B收牌
                    arrayDequeB.offer(dequeB);
                    while (!dequeB.equals(stack.peek())){
                        arr[Integer.parseInt(stack.peek().toString())] = 0;  //令牌桶元素清空
                        arrayDequeB.offer(stack.pop().toString());

                    }
                    arr[Integer.parseInt(stack.peek().toString())] = 0;  //令牌桶元素清空
                    arrayDequeB.offer(stack.pop().toString());
                }
            }
        }

        //小哼牌空了，小哈赢
        if(arrayDequeA.isEmpty()){
            result[0] = "小哈win";
            result[1] = arrayDequeB.toString();
            result[2] = stack.toString();
            return result;
        }
        //小哈牌空了，小哼赢
        if(arrayDequeB.isEmpty()){
            result[0] = "小哼win";
            result[1] = arrayDequeB.toString();
            result[2] = stack.toString();
            return result;
        }


        return result;
    }

    public static void main(String[] args) {
        //小哼手中有 6 张牌，顺序为 2 4 1 2 5 6，小哈手中也有 6 张牌，顺序 为 3 1 3 5 6 4，
        /**
         * 小哈win，小哼出完牌，小哈就不出了
         * 小哈当前手中的牌是 [1, 6, 5, 2, 3, 4, 1]
         * 桌上的牌是 [2, 6, 5, 4, 3]
         */
        //小哼手中的牌
        ArrayDeque<String> queueA = new ArrayDeque();
        queueA.offer("2");
        queueA.offer("4");
        queueA.offer("1");
        queueA.offer("2");
        queueA.offer("5");
        queueA.offer("6");
        //小哈手中的牌
        ArrayDeque<String> queueB = new ArrayDeque();
        queueB.offer("3");
        queueB.offer("1");
        queueB.offer("3");
        queueB.offer("5");
        queueB.offer("6");
        queueB.offer("4");
        String[] strings = catFishingUtil(queueA, queueB);
        Arrays.asList(strings).stream().forEach(s -> System.out.println(s));

    }

}
