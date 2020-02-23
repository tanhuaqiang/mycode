package com.dalingjia.thead.threadCommunication.condition;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    //使用同步锁来保证线程同步
    private final Lock lock = new ReentrantLock();

    //使用condition对象来进行线程通信
    private final Condition condition = lock.newCondition();

    //账号编号
    private String accountNo;

    //账号余额
    private Double balance;

    public Account(String accountNo, Double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public  void draw(double drawAmount) {
        lock.lock();
        try {
            //没钱，等待
            if(!(balance>0)) {
                condition.await();
            }else {
                balance -= drawAmount;
                System.out.println(Thread.currentThread().getName() + "<-取走：" + drawAmount + " ,余额：" + balance);
                condition.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //使用finally块来释放锁
            lock.unlock();
        }

    }

    //存钱
    public synchronized void deposit(double depositAmount) {
        lock.lock();
        try {
            //账户有钱，等待
            if (balance > 0) {
                condition.await();
            } else {
                balance += depositAmount;
                System.out.println(Thread.currentThread().getName() + "->存进：" + depositAmount + " ,余额：" + balance);
                condition.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //使用finally块来释放锁
            lock.unlock();
        }
    }
}
