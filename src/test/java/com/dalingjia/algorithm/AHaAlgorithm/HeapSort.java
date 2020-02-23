package com.dalingjia.algorithm.AHaAlgorithm;

class Data{
    int a;
    int b;
}
public class HeapSort {

    private static int b[] = {0, 99, 5, 36, 2, 19, 1, 46, 12, 7, 22, 25, 28, 17, 92};
    static int n = b.length-1;

    //调整函数
    private static void shifDown(int i){
        int t = 0; //t用来记录较小值的编号
        int flag = 0; //flag记录是否还需要向下比较
        while (i * 2 <= n && flag ==0){
            //与左子树进行比较
            if(b[i] > b[i*2]){
                t = i*2;
            }else {
                t = i;
            }
            //是否存在右子树
            if(2*i+1 <=n){
                if(b[t] > b[i*2+1]){
                    t = i*2+1;
                }
            }

            if(t!=i){
                swap(i,t);
                i = t;//更新i结点与他刚刚交换的儿子结点的编号，以便继续向下调整
            }else {
                flag = 1;//说明当前结点比他的两个儿子结点都要小，不用再往下调整
            }
        }
    }

    //创建小顶堆
    private static void create(){
        for (int i = n/2; i >=1 ; i--) {
            shifDown(i);
        }
    }

    //交换两个数
    private static void swap(int x, int y){
        b[x] = b[x] ^ b[y];
        b[y] = b[x] ^ b[y];
        b[x] = b[x] ^ b[y];
    }

    private static int getMin(){
        int min = b[1];
        b[1] = b[n];//将堆中最后一个元素赋值到堆顶
        n--;//减少堆中的元素
        shifDown(1);//重新调整小顶堆
        return min;
    }

    public static void main(String[] args) {

        create();
        for (int i = 1; i < b.length; i++) {
            System.out.print(b[i] + ",");
        }
        System.out.println();
        for (int i = 1; i < b.length; i++) {
            System.out.print(getMin() + ",");
        }
    }
}
