package demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Coder编程
 * @Title: MyAnnotationParameter
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/4/22 14:20
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotationParameter {
    /**
     * 定义注解的一个元素 并给定默认值
     * @return
     */
    String value() default "我是定义在参数上的注解元素value的默认值";

    /**
     * 定义注解类型
     * @return
     */
    int type() default 1;

}
