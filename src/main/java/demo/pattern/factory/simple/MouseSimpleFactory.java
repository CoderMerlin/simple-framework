package demo.pattern.factory.simple;

import demo.pattern.factory.entity.DellMouse;
import demo.pattern.factory.entity.HpMouse;
import demo.pattern.factory.entity.Mouse;

/**
 * @author Coder编程
 * @Title: MouseFactory
 * @ProjectName simple-framework
 * @Description: 简单工厂模式
 * @date 2021/4/21 15:21
 */
public class MouseSimpleFactory {

    /**
     * 对简单工厂类：
     * 缺点：新增，修改都会违反开闭原则，例如：再新增一个联想鼠标，则需要修改factory
     * @param type
     * @return
     */
    public static Mouse createMouse(int type){
        switch (type){
            case 0: return new HpMouse();
            case 1: return new DellMouse();
            default: return new HpMouse();
        }
    }

}
