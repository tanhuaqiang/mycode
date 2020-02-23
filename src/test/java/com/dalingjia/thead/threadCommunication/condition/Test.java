package com.dalingjia.thead.threadCommunication.condition;

public class Test {

    public static void main(String[] args) {
        //1,定义一个账户
        Account account = new Account("thq10000", 0d);
        //2，准备target
        DepositThread depositThread = new DepositThread("存",account, 100d);
        DrawThread drawThread = new DrawThread( "取",account, 100d);
        //3,开启2个线程
        depositThread.start();
        drawThread.start();
    }
}
