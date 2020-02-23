package com.dalingjia.myThreadPool;

public interface Callable<T> {

    /**
     * 执行任务
     * @return 执行结果
     */
    T call() ;
}