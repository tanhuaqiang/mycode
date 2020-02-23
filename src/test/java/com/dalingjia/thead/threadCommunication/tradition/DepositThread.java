package com.dalingjia.thead.threadCommunication.tradition;

/**
 * 存钱线程
 */
public class DepositThread extends Thread {

    private Account account;

    //存钱数量
    private Double amount;

    public DepositThread(String name, Account account, Double amount) {
        super(name);
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            account.deposit(amount);
        }
    }
}
