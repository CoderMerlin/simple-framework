package demo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Coder编程
 * @Title: ReflectTarget
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/4/21 16:59
 */
public class ReflectTarget {

    /**
     * 构造函数
     */
    /*默认的带参数的构造函数*/
    ReflectTarget(String str) {
        System.out.println("默认的构造方法！" + str);
    }

    /*无参构造函数*/
    public ReflectTarget() {
        System.out.println("调用了public方法的无参构造方法！");
    }

    /*有一个参数的构造函数*/
    public ReflectTarget(char name) {
        System.out.println("调用了public方法的有一个有参构造方法！name=" + name);
    }

    /*public方法的有多个参数的构造方法*/
    public ReflectTarget(String name, int index) {
        System.out.println("调用了public方法的有多个参数的构造方法！name=" + name + "序号 = " + index);
    }

    /*受保护的构造函数*/
    protected ReflectTarget(boolean n) {
        System.out.println("调用了protected方法的n=" + n);
    }

    /*私有的有参构造*/
    private ReflectTarget(int n) {
        System.out.println("调用了private方法的n=" + n);
    }


    /**
     * 字段
     ***/
    public String name;
    protected int index;
    char type;
    private String targetInfo;

    @Override
    public String toString() {
        return "ReflectTarget{" +
                "name='" + name + '\'' +
                ", index=" + index +
                ", type=" + type +
                ", targetInfo='" + targetInfo + '\'' +
                '}';
    }


    public void show1(String str){
        System.out.println("调用了公有的show1()方法，String参数 Str= "+str);
    }

    protected void show2(){
        System.out.println("调用了受保护的show2(),无参方法");
    }

    void show3(){
        System.out.println("调用了默认的show3(),无参方法");
    }

    private String show4(int index){
        System.out.println("调用了私有方法show4,并且有返回值，有参数 index = " + index);
        return "show4";
    }



    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        //第一种方式获取Class对象
        ReflectTarget reflectTarget = new ReflectTarget();
        Class class1 = reflectTarget.getClass();

        System.out.println("第一种方式获取Class名称：" + class1.getName());

        //第二种方式获取Class对象
        Class class2 = ReflectTarget.class;
        System.out.println("第二种方式获取Class名称：" + class2.getName());

        //判断是否相等
        System.out.println(class1.getName() == class2.getName());

        //第三种方式获取Class对象
        Class class3 = Class.forName("demo.reflect.ReflectTarget");
        System.out.println("第三种方式获取Class名称：" + class3.getName());

        /*-----------------------------------------------------------------*/

        Class clazz = Class.forName("demo.reflect.ReflectTarget");

        //获取所有的公有构造方法
        System.out.println("*******************所有公有构造方法*********************");
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        //获取所有构造方法
        System.out.println("*******************所有构造方法*********************");

        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }

        //获取单个带参数的公有方法
        System.out.println("*******************获取单个带参数的公有方法*********************");
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        System.out.println(constructor);

        //获取私有的构造方法
        System.out.println("*******************获取私有的构造方法*********************");
        Constructor declaredConstructor = clazz.getDeclaredConstructor(int.class);
        System.out.println(declaredConstructor);

        //通过构造函数 创建实例
        //私有的构造函数需要暴力方法，设置为true,公有方法不需要暴力访问
        declaredConstructor.setAccessible(true);
        ReflectTarget reflectTarget1 = (ReflectTarget) declaredConstructor.newInstance(1);


        /***********************获取成员变量***********************/

        System.out.println("*******************a.获取所有公有的字段*********************");
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("*******************b.获取所有字段（包括私有，受保护，默认的）*********************");
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        System.out.println("*******************c.获取公有字段并调用*********************");
        Field name = clazz.getField("name");
        System.out.println("输出公有字段name = " + name);

        System.out.println("*******************d.获取私有字段并调用进行修改*********************");
        Field targetInfo = clazz.getDeclaredField("targetInfo");
        targetInfo.setAccessible(true);
        targetInfo.set(reflectTarget1,"Coder编程");
        System.out.println("输出私有字段targetInfo = " + reflectTarget1);


        /***********************获取方法***********************/
        System.out.println("*******************a.获取所有共有方法*********************");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("*******************b.获取所有方法(公，私，默认)*********************");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        System.out.println("*******************c.获取公有方法show1()*********************");
        Method show1 = clazz.getMethod("show1", String.class);
        System.out.println(show1);

        System.out.println("*******************d.获取show1()后并调用*********************");
        ReflectTarget reflectTarget2 = (ReflectTarget)clazz.getConstructor().newInstance();
        show1.invoke(reflectTarget2,"Coder编程");

        System.out.println("*******************e.获取show4()后并调用*********************");
        Method show4 = clazz.getDeclaredMethod("show4", int.class);
        System.out.println(show4);
        show4.setAccessible(true);
        show4.invoke(reflectTarget2,1);

    }
}
