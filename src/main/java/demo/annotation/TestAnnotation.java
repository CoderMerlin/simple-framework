package demo.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Coder编程
 * @Title: TestAnnotion
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/4/22 14:20
 */
@MyAnTargetType
public class TestAnnotation {

    @MyAnTargetField
    private String field = "我是字段";

    @MyAnTargetMethod("测试方法")
    public void methodTest(@MyAnTargetParameter("测试参数")String str){
        System.out.println("我是测试方法,Str = " + str);
    }

    /**
     * 获取类上的注解
     * @throws ClassNotFoundException
     */
    public static void parseTypeAnnotation() throws ClassNotFoundException {
        //获取类上的注解
        MyAnTargetType annotation = TestAnnotation.class.getAnnotation(MyAnTargetType.class);
        System.out.println("类上注解"+annotation);

        //另外一种方法
        Class clazz = Class.forName("demo.annotation.TestAnnotation");
        /*获取到类上的所有注解，只在类上，不包括成员，方法上的注解*/
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation1 : annotations) {
            MyAnTargetType myAnTargetType = (MyAnTargetType)annotation1;
            System.out.println(myAnTargetType.value());
        }
    }

    /**
     * 获取字段上的注解
     * @throws ClassNotFoundException
     */
    public static void parseFieldAnnotation() throws ClassNotFoundException {
        Class clazz = Class.forName("demo.annotation.TestAnnotation");
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            //判断成员变量中是否有指定注解类型的注解
            boolean hasAnnotation = declaredField.isAnnotationPresent(MyAnTargetField.class);
            if(hasAnnotation){
                MyAnTargetField annotation = declaredField.getAnnotation(MyAnTargetField.class);
                System.out.println(annotation.value());
            }
        }
    }

    public static void parseMethodAnnotation() throws ClassNotFoundException, NoSuchMethodException {
        Class clazz = Class.forName("demo.annotation.TestAnnotation");
        Method methodTest = clazz.getDeclaredMethod("methodTest", String.class);
        MyAnTargetMethod annotation = methodTest.getAnnotation(MyAnTargetMethod.class);
        System.out.println(annotation.value());

        Annotation[][] parameterAnnotations = methodTest.getParameterAnnotations();
        for (Annotation[] parameterAnnotation : parameterAnnotations) {
            for (Annotation annotation1 : parameterAnnotation) {
                if(annotation1 instanceof MyAnTargetParameter){
                    System.out.println("方法参数上的注解："+((MyAnTargetParameter) annotation1).value());
                }
            }
        }
    }


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        //parseTypeAnnotation();
       // parseFieldAnnotation();
        parseMethodAnnotation();
    }
}
