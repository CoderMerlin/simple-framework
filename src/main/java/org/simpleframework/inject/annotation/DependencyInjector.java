package org.simpleframework.inject.annotation;

import lombok.extern.slf4j.Slf4j;
import org.simpleframework.core.BeanContainer;
import org.simpleframework.util.ClassUtil;
import org.simpleframework.util.ValidationUtil;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * @author Coder编程
 * @Title: DependencyInjector
 * @ProjectName simple-framework
 * @Description: 依赖注入
 * @date 2021/5/7 15:30
 */
@Slf4j
public class DependencyInjector {

    /**
     * Bean容器
     */
    private BeanContainer beanContainer;

    public DependencyInjector() {
        beanContainer = BeanContainer.getInstance();
    }

    /**
     * 执行ioc
     */
    public void doIoc() {
        //1.遍历Bean容器中所有的Class对象
        Set<Class<?>> classSet = beanContainer.getClasses();
        if (ValidationUtil.isEmpty(classSet)) {
            log.warn("empty classSet in BeanContainer");
            return;
        }
        for (Class<?> clazz : classSet) {
            //2.遍历Class对象的所有成员变量
            Field[] fields = clazz.getDeclaredFields();
            if (ValidationUtil.isEmpty(fields)) {
                continue;
            }
            //3.找出被Autowired标记的成员变量
            for (Field field : fields) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    Autowired annotation = field.getAnnotation(Autowired.class);
                    String autowiredValue = annotation.value();
                    //4.获取这些成员变量的类型
                    Class<?> fieldClass = field.getType();
                    //5.获取这些成员变量的类型在容器里对应的实例
                    Object fieldValue = getFieldInstance(fieldClass, autowiredValue);
                    if (fieldValue == null) {
                        throw new RuntimeException("unable to inject relevant type,target fieldClass is." + fieldClass.getName());
                    } else {
                        //6.通过反射将对应的成员变量实例注入到成员变量所在类的实例里
                        Object targetBean = beanContainer.getBean(clazz);
                        ClassUtil.setField(field, targetBean, fieldValue, true);
                    }
                }
            }

        }


    }

    /**
     * 根据Class在beanContainer里获取其实例或者实现类
     *
     * @param fieldClass
     * @return
     */
    private Object getFieldInstance(Class<?> fieldClass, String autowiredValue) {
        Object fieldValue = beanContainer.getBean(fieldClass);
        if (fieldValue != null) {
            return fieldValue;
        } else {
            Class<?> implementedClass = getImplementClass(fieldClass, autowiredValue);
            if (implementedClass != null) {
                return beanContainer.getBean(implementedClass);
            } else {
                return null;
            }
        }
    }

    /**
     * 获取接口的实现类
     *
     * @param fieldClass
     * @param autowiredValue
     * @return
     */
    private Class<?> getImplementClass(Class<?> fieldClass, String autowiredValue) {
        Set<Class<?>> classesBySuper = beanContainer.getClassesBySuper(fieldClass);
        if (!ValidationUtil.isEmpty(classesBySuper)) {
            //如果没有设置value
            if (ValidationUtil.isEmpty(autowiredValue)) {
                if (classesBySuper.size() == 1) {
                    return classesBySuper.iterator().next();
                } else {
                    throw new RuntimeException("multiple implemented classes for" + fieldClass.getName() + "please set @Autowired's value to pick one");
                }
            } else {
                for (Class<?> clazz : classesBySuper) {
                    if (autowiredValue.equals(clazz.getSimpleName())) {
                        return clazz;
                    }
                }
            }
        }
        return null;
    }
}
