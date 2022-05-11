package com.dalingjia.leetcode.array;

import java.util.Scanner;

//使用数组实现环形队列,复用前面单向队列
class CircleArrayQueue {
    private int maxSize;//数组的最大容量
    private int front = 0;//指向第一个元素
    private int rear = 0;//指向最后一个元素的后面
    private int[] arr;

    //在构造器中创建数组
    public CircleArrayQueue(int n) {
        maxSize = n;
        arr = new int[maxSize];
    }

    //判断是否已满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //进入队列
    public void addQueue(int data) {
        if (isFull()) {
            System.out.println("队列已满!");
            return;
        }
        arr[rear] = data;
        rear = (rear + 1) % maxSize;
    }

    //取出队列元素
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取出!!!");
        }
//        return arr[front++];
        //上面这行代码没有考虑到front也需要取模
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }


    //输出当前队列
    public void show() {
        if (isEmpty()) {
            System.out.println("空的");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d", i % maxSize, arr[i % maxSize]);
            System.out.println();
        }
    }

    //求出当前队列有效数字个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //输出当前头部元素
    public int head() {
        if (isEmpty()) {
            System.out.println("空的");
        }
        return arr[front];
    }

}

public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        //菜单
        CircleArrayQueue queue = new CircleArrayQueue(5);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);

        boolean loop = true;

        while (loop) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("s(show)表示输出队列");
            System.out.println("a(add)代表添加元素");
            System.out.println("g(get)代表取出元素");
            System.out.println("h(head)代表获取头部元素");
            System.out.println("e(exit)代表退出程序");
            System.out.println("请输入进行的操作：");
            key = scanner.next().charAt(0);//接受一个字符
            switch (key) {
                case 's':
                    queue.show();
                    break;
                case 'a':
                    System.out.println("请输入添加de的数字：");
                    int item = scanner.nextInt();
                    queue.addQueue(item);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.println("取出的数字为" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    int res2 = queue.head();
                    System.out.println("当前的头部元素为" + res2);
                    break;
                case 'e':
                    loop = false;
                    System.out.println("程序退出~~~");
                    return;
                default:
                    break;

            }
        }
    }
}
