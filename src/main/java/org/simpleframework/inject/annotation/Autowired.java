package org.simpleframework.inject.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Coder编程
 * @Title: Autowired
 * @ProjectName simple-framework
 * @Description: Autowired目前只支持成员注入
 * @date 2021/5/7 15:29
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Autowired {

    String value() default "";
}
