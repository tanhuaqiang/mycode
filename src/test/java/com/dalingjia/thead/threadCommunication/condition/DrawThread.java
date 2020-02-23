package com.dalingjia.thead.threadCommunication.condition;

public class DrawThread extends Thread {

    private Account account;

    private Double amount;

    public DrawThread(String name, Account account, Double amount) {
        super(name);
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            account.draw(amount);
        }
    }
}
