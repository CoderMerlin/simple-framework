package demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Coder编程
 * @Title: MyAnnotationField
 * @ProjectName simple-framework
 * @Description: 定义一个可以注解在FIELD上的注解
 * @date 2021/4/22 14:17
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotationField {
    /**
     * 定义注解的一个元素 并给定默认值
     * @return
     */
    String value() default "我是定义在字段上的注解元素value的默认值";

    /**
     * 定义注解一个type类型
     * @return
     */
    int type();
}
