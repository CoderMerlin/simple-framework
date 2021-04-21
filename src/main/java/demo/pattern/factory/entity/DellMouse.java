package demo.pattern.factory.entity;

/**
 * @author Coder编程
 * @Title: DellMouse
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/4/21 15:24
 */
public class DellMouse implements Mouse{
    @Override
    public void sayHi() {
        System.out.println("我是戴尔鼠标！");
    }
}
