package com.dalingjia.thead.letterPrint;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) {

        //定义一个带缓存的线程池
        ExecutorService service = Executors.newCachedThreadPool();

        //使用一个仓库
        LetterList letterList = new LetterList();

        //定义一个生产者和一个消费者
        Vowel vowel = new Vowel("元音线程", letterList);
        Consonant consonant = new Consonant("辅音线程", letterList);

        //向线程池中提交线程
        service.submit(vowel);
        service.submit(consonant);
    }
}
