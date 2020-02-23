package com.dalingjia.pattern.factoryPattern;

import com.dalingjia.pattern.simpleFactoryPattern.Fruit;
import com.dalingjia.pattern.simpleFactoryPattern.Pear;

public class PearFactory implements FruitFactory {
    @Override
    public Fruit createFruit() {
        return new Pear();
    }
}