package com.dalingjia.algorithm.AHaAlgorithm;

public class FullArrange {

    //存放手中的牌
    private static int hand[] = new int[10];
    //盒子中的牌
    private static int box[] = new int[10];

    private static Long count = 0L;

    public static void fullArrange(int step, int n){
        if(step == n+1){
            for (int i = 1; i <= n; i++) {
                System.out.print(box[i]);
            }
            count++;
            System.out.println();
            return;//返回到上一个fullArrange()
        }

        for (int i = 1; i <= n; i++) {
            if(hand[i] == 0){//手中有该张牌
                box[step] = i;
                hand[i] = 1;//置为1，表示手中的牌已放入盒子中
                fullArrange(step + 1, n);//继续往下一个盒子中放牌
                hand[i] = 0;//排玩序，从盒子中取出牌
            }
        }
    }


    //*** + *** = ***
    public static void main(String[] args) {
        fullArrange(1, 2);
        System.out.println("count = " + count);

    }
}
