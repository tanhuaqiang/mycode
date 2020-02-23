package com.dalingjia.pattern.factoryPattern;

import com.dalingjia.pattern.simpleFactoryPattern.Apple;
import com.dalingjia.pattern.simpleFactoryPattern.Fruit;

public class AppleFactory implements FruitFactory {

    @Override
    public Fruit createFruit() {
        return new Apple();
    }
}