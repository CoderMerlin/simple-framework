package demo.pattern.factory.method;

import demo.pattern.factory.entity.HpMouse;
import demo.pattern.factory.entity.Mouse;

/**
 * @author Coder编程
 * @Title: HpMouseFactory
 * @ProjectName simple-framework
 * @Description: 惠普鼠标工厂
 * @date 2021/4/21 15:46
 */
public class HpMouseFactory implements MouseFactory{
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }
}
