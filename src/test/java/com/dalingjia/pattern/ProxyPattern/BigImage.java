package com.dalingjia.pattern.ProxyPattern;

public class BigImage implements Image {

    public BigImage() {
        try {
            //系统延时3秒用来模拟调用大图片时有系统延时
            Thread.sleep(3000);
            System.out.println("Image Successfully loaded.");
        } catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void show() {
        System.out.println("Draw Real Image");
    }
}