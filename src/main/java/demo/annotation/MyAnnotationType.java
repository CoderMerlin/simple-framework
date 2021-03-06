package demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Coder编程
 * @Title: MyAnnotationType
 * @ProjectName simple-framework
 * @Description: 定义一个可以注解在Class,interface,enum上的注解
 * @date 2021/4/22 14:15
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotationType {

    /**
     * 定义注解的一个元素 并给定默认值
     * @return
     */
    String value() default "我是定义在类接口枚举类上的注解元素value的默认值";
}
