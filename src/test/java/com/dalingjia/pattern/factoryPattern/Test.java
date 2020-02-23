package com.dalingjia.pattern.factoryPattern;

import com.dalingjia.pattern.simpleFactoryPattern.Apple;
import com.dalingjia.pattern.simpleFactoryPattern.Pear;

/**
 * @author tanhq
 * @Description TODO
 * @Date 2019/11/23 下午11:32
 * @Version 1.0
 **/
public class Test {

    /**
     * 以上这种方式，虽然解耦了，也遵循了开闭原则，但是问题根本还是没有解决啊，换汤没换药，
     * 如果我需要的产品很多的话，需要创建非常多的工厂，所以这种方式的缺点也很明显；
     * @param args
     */
    public static void main(String[] args) {
        FruitFactory appleFactory = new AppleFactory();
        FruitFactory pearFactory = new PearFactory();
        Apple apple = (Apple) appleFactory.createFruit();//获得苹果
        Pear pear = (Pear) pearFactory.createFruit();//获得梨
    }
}

 
    
    
    
    