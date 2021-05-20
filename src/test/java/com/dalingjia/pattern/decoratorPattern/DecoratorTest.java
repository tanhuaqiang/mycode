package com.dalingjia.pattern.decoratorPattern;

/**
 * 装饰者模式
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Component component = new ConcreteDecorator2(new ConcreteDecorator1(new ConcreteComponent()));
        component.operation();
    }
}

/**
 * 定义一个接口组件
 */
interface Component{
    void operation();
}

/**
 * 具体的组件
 */
class ConcreteComponent implements Component{

    @Override
    public void operation() {
        System.out.println("拍照。");
    }
}

/**
 * 装饰者抽象
 */
abstract class Decorator implements Component{
    Component component;

    public Decorator(Component component) {
        this.component = component;
    }
}

class ConcreteDecorator1 extends Decorator{
    public ConcreteDecorator1(Component component) {
        super(component);
    }
    @Override
    public void operation() {
        System.out.println("添加美颜。");
        component.operation();
    }
}

class ConcreteDecorator2 extends Decorator{

    public ConcreteDecorator2(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("添加滤镜。");
        component.operation();
    }
}