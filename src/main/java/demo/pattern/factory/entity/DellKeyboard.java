package demo.pattern.factory.entity;

/**
 * @author Coder编程
 * @Title: DellKeyboard
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/4/21 16:20
 */
public class DellKeyboard implements Keyboard{
    @Override
    public void sayHello() {
        System.out.println("我是戴尔键盘！");
    }
}
