package demo.pattern.factory;

import demo.pattern.factory.abstractf.ComputerFactory;
import demo.pattern.factory.abstractf.HpComputerFactory;
import demo.pattern.factory.entity.Keyboard;
import demo.pattern.factory.entity.Mouse;
import demo.pattern.factory.method.HpMouseFactory;

import demo.pattern.factory.method.MouseFactory;
import demo.pattern.factory.simple.MouseSimpleFactory;

/**
 * @author Coder编程
 * @Title: Test
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/4/21 15:26
 */
public class Test {

    public static void main(String[] args) {

        //简单工厂模式
        Mouse mouse = MouseSimpleFactory.createMouse(1);
        mouse.sayHi();

        //工厂方法模式
        MouseFactory mouseFactory = new HpMouseFactory();
        Mouse mouse1 = mouseFactory.createMouse();
        mouse1.sayHi();

        //抽象工厂模式
        ComputerFactory computerFactory = new HpComputerFactory();
        Keyboard keyboard = computerFactory.createKeyboard();
        Mouse mouse2 = computerFactory.createMouse();
        keyboard.sayHello();
        mouse2.sayHi();
    }
}
