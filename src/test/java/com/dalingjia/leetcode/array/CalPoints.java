package com.dalingjia.leetcode.array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author tanhq
 * @Description  682 棒球比赛
 * @Date 2019/9/8 下午10:44
 * @Version 1.0
 **/
public class CalPoints {

    /**
     * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
     * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
     * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
     * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
     * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
     * @param ops
     * @return
     */
    public int calPoints(String[] ops) {
        int sum = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : ops) {
            switch (s) {
                case "+":
                    //取出
                    int first = stack.pop();
                    //获取但不取出
                    int second = stack.peek();
                    sum+= (first+second);
                    stack.push(first);
                    stack.push(first+second);
                    break;
                case "D":
                    int temp = stack.peek();
                    sum += 2*temp;
                    stack.push(2 * temp);
                    break;
                case "C":
                    sum -= stack.pop();
                    break;
                default:
                    sum += Integer.parseInt(s);
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }
        return sum;
    }
}

 
    
    
    
    