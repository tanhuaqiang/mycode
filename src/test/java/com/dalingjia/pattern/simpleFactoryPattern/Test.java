package com.dalingjia.pattern.simpleFactoryPattern;

/**
 * @author tanhq
 * @Description TODO
 * @Date 2019/11/23 下午11:31
 * @Version 1.0
 **/
public class Test {

    /**
     * 以上的这种方式，每当我想添加一种水果，就必然要修改工厂类，这显然违反了开闭原则，亦不可取；
     * 所以简单工厂只适合于产品对象较少，且产品固定的需求，对于产品变化无常的需求来说显然不合适
     * @param args
     */
    public static void main(String[] args) {
        FruitFactory mFactory = new FruitFactory();
        Apple apple = (Apple) mFactory.createFruit("apple");//获得苹果
        Pear pear = (Pear) mFactory.createFruit("pear");//获得梨
    }
}

 
    
    
    
    