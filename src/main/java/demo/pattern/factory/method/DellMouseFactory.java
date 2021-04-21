package demo.pattern.factory.method;

import demo.pattern.factory.entity.DellMouse;
import demo.pattern.factory.entity.Mouse;

/**
 * @author Coder编程
 * @Title: DellMouseFactory
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/4/21 15:45
 */
public class DellMouseFactory implements MouseFactory{
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }
}
