package demo.pattern.factory.abstractf;

import demo.pattern.factory.entity.DellKeyboard;
import demo.pattern.factory.entity.DellMouse;
import demo.pattern.factory.entity.Keyboard;
import demo.pattern.factory.entity.Mouse;

/**
 * @author Coder编程
 * @Title: DellComputerFactory
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/4/21 16:30
 */
public class DellComputerFactory implements ComputerFactory{
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new DellKeyboard();
    }
}
