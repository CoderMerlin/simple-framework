package demo.pattern.factory.abstractf;

import demo.pattern.factory.entity.Keyboard;
import demo.pattern.factory.entity.Mouse;

/**
 * @author Coder编程
 * @Title: ComputerFactroy
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/4/21 16:16
 */
public interface ComputerFactory {

    Mouse createMouse();

    Keyboard createKeyboard();
}
