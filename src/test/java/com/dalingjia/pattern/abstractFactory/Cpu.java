package com.dalingjia.pattern.abstractFactory;

public interface Cpu {

    void run();

    class Cpu650 implements Cpu {
        @Override
        public void run() {
            //650 也厉害
        }
    }

    class Cpu825 implements Cpu {
        @Override
        public void run() {
            //825 处理更强劲
        }
    }
}