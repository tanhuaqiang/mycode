package com.dalingjia.thead.threadCommunication.tradition;

public class Account {

    //账号编号
    private String accountNo;

    //账号余额
    private Double balance;


    public Account(String accountNo, Double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public synchronized void draw(double drawAmount) {
        try {
            //账户没钱，等待
            if (!(balance > 0)) {
                wait();
            } else {
                balance -= drawAmount;
                System.out.println(Thread.currentThread().getName() + "<-取走：" + drawAmount + " ,余额：" + balance);
                notifyAll();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //存钱
    public synchronized void deposit(double depositAmount) {
        try {
            //账户有钱，等待
            if (balance > 0) {
                wait();
            } else {
                balance += depositAmount;
                System.out.println(Thread.currentThread().getName() + "->存进：" + depositAmount + " ,余额：" + balance);
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
