package com.dalingjia.JVM;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaVMStackSOF {

    static Logger logger = LoggerFactory.getLogger(JavaVMStackSOF.class);

    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    /**
     * 栈容量参数只由-Xss参数设定
     * -Xss160m
     * @param args
     */
    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
//        try{
//            oom.stackLeak();
//        }catch (Throwable e){
//            System.out.println("stack length:" + oom.stackLength);
//            throw e;
//        }
        oom.stackLeakByThread();
    }

    //多线程
    private void dontStop(){
        System.out.println("多线程模拟栈溢出！");
    }
    public void stackLeakByThread(){
        while (true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }
}
