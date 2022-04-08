package com.dalingjia.pattern.ProxyPattern;

public class ImageProxy implements Image {

    private Image image;

    public ImageProxy(Image image) {
        this.image = image;
    }

    public void show() {
        if (image == null) {
            image = new BigImage();
        }
        image.show();
    }
}