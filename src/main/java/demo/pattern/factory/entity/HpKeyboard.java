package demo.pattern.factory.entity;

/**
 * @author Coder编程
 * @Title: HpKeyboard
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/4/21 16:19
 */
public class HpKeyboard implements Keyboard{
    @Override
    public void sayHello() {
        System.out.println("我是惠普键盘！");
    }
}
