package demo.pattern.factory.entity;

/**
 * @author Coder编程
 * @Title: HpMouse
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/4/21 15:22
 */
public class HpMouse implements Mouse{
    @Override
    public void sayHi() {
        System.out.println("我是惠普鼠标！");
    }
}
