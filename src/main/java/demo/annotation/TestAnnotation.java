package demo.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Coder编程
 * @Title: TestAnnotation
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/4/22 14:20
 */
@MyAnnotationType("我是注解类")
public class TestAnnotation {

    @MyAnnotationField(type = 1)
    private String field = "我是字段";

    @MyAnnotationMethod("测试方法")
    public void methodTest(@MyAnnotationParameter("测试参数")String str){
        System.out.println("我是测试方法,Str = " + str);
    }

    /**
     * 获取类上的注解
     * @throws ClassNotFoundException
     */
    public static void parseTypeAnnotation() throws ClassNotFoundException {
        //获取类上的注解
        MyAnnotationType annotation = TestAnnotation.class.getAnnotation(MyAnnotationType.class);
        System.out.println("类上注解"+annotation);

        //另外一种方法
        Class clazz = Class.forName("demo.annotation.TestAnnotation");
        /*获取到类上的所有注解，只在类上，不包括成员，方法上的注解*/
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation1 : annotations) {
            MyAnnotationType myAnnotationType = (MyAnnotationType)annotation1;
            System.out.println(myAnnotationType.value());
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
            boolean hasAnnotation = declaredField.isAnnotationPresent(MyAnnotationField.class);
            if(hasAnnotation){
                MyAnnotationField annotation = declaredField.getAnnotation(MyAnnotationField.class);
                System.out.println(annotation.value());
            }
        }
    }

    /**
     * 获取方法，参数上的注解
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     */
    public static void parseMethodAnnotation() throws ClassNotFoundException, NoSuchMethodException {
        Class clazz = Class.forName("demo.annotation.TestAnnotation");
        Method methodTest = clazz.getDeclaredMethod("methodTest", String.class);
        MyAnnotationMethod annotation = methodTest.getAnnotation(MyAnnotationMethod.class);
        System.out.println(annotation.value());

        Annotation[][] parameterAnnotations = methodTest.getParameterAnnotations();
        for (Annotation[] parameterAnnotation : parameterAnnotations) {
            for (Annotation annotation1 : parameterAnnotation) {
                if(annotation1 instanceof MyAnnotationParameter){
                    System.out.println("方法参数上的注解："+((MyAnnotationParameter) annotation1).value());
                }
            }
        }
    }


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        parseTypeAnnotation();
       // parseFieldAnnotation();
        //parseMethodAnnotation();
    }
}
