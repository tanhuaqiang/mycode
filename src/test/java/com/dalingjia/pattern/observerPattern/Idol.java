package com.dalingjia.pattern.observerPattern;

/**
 * @author tanhq
 * @Description 第三步：定义抽象主题(Subject)：抽象明星
 * @Date 2019/11/24 上午12:15
 * @Version 1.0
 **/
public interface Idol {

    /**
     * 添加粉丝
     * @param fan
     */
    void addFan(Fan fan);

    /**
     * 删除粉丝
     * @param fan
     */
    void delFan(Fan fan);

    /**
     * 通知粉丝
     * @param message
     */
    void notify(String message);

}
