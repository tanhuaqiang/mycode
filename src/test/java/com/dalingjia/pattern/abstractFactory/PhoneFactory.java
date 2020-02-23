package com.dalingjia.pattern.abstractFactory;

public interface PhoneFactory {

    Cpu getCpu();//使用的cpu

    Screen getScreen();//使用的屏幕
}