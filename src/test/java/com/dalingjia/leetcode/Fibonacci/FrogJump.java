package com.dalingjia.leetcode.Fibonacci;

/**
 * 一只青蛙一次可以跳上一级台阶，也可以跳上2级。求该青蛙跳上一个n级台阶共有多少种跳法
 */
public class FrogJump {

    /**
     * 思路：n级台阶对应函数f(n)种跳法。
     *  若第一次跳1级，则剩余n-1级台阶，共f(n-1)种跳法；若第一次跳2级，则剩余n-2级台阶，共f(n-2)种跳法
     *  两种跳法加起来，就是f(n-1) + f(n-2)种跳法
     *  斐波拉契的出口就是：只有一级的时候f(1)=1,只有2级的时候f(2)=2
     * @param n
     * @return
     */
    public static int jump(int n){
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }else {
            return jump(n - 1) + jump(n - 2);
        }
    }

    public static void main(String[] args) {
//        System.out.println(jump(4));
//        System.out.println(jump(5));
//        Long start1 = System.currentTimeMillis();
//        System.out.println(jump(44));
//        System.out.println(System.currentTimeMillis() - start1);

        Long start2 = System.currentTimeMillis();
        System.out.println(JumpFloor(44));
        System.out.println(System.currentTimeMillis() - start2);
    }

    /**
     * 非递归实现，将递归换成变量来实现
     * @param n
     * @return
     */
    public static int JumpFloor(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;

    }

}
