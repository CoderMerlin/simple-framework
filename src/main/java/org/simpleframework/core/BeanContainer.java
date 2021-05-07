package org.simpleframework.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.simpleframework.core.annotation.Component;
import org.simpleframework.core.annotation.Controller;
import org.simpleframework.core.annotation.Repository;
import org.simpleframework.core.annotation.Service;
import org.simpleframework.util.ClassUtil;
import org.simpleframework.util.ValidationUtil;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Coder编程
 * @Title: BeanContainer
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/5/6 17:05
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BeanContainer {

    /**
     * 存放所有被配置标记的目标对象的Map
     */
    private final Map<Class<?>,Object> beanMap = new ConcurrentHashMap<>();

    public static final List<Class<? extends Annotation> > BEAN_ANNOTATION = Arrays.asList(Component.class, Controller.class, Service.class, Repository.class);


    /**
     * 获取bean的容器实例
     * @return
     */
    public static BeanContainer getInstance(){
        return ContainerHolder.HOLDER.instance;
    }

    private enum ContainerHolder{
        /**
         * 单例
         */
        HOLDER;
        private BeanContainer instance;
        ContainerHolder(){
            instance = new BeanContainer();
        }
    }

    /**
     * 容器是否已经加载过
     */
    private boolean loaded = false;

    /**
     * 容器是否已加载
     * @return 是否已加载
     */
    public boolean isLoaded(){
        return loaded;
    }

    /**
     * bean实例数量
     * @return 数量
     */
    public int size(){
        return beanMap.size();
    }

    /**
     * 扫描加载所有的bean
     * @param packageName:包名
     */
    public void loadBeans(String packageName){
        //判断bean容器是否已经加载过
        if(loaded){
            log.warn("BeanContainer has been loaded.");
            return;
        }

        Set<Class<?>> classSet = ClassUtil.extractPackageClass(packageName);
        if(ValidationUtil.isEmpty(classSet)){
            log.warn("extract nothing from packageName" + packageName);
            return;
        }
        for (Class<?> clazz : classSet) {
            for (Class<? extends Annotation> annotation : BEAN_ANNOTATION) {
                //如果类上面标记了定义的注解
                if(clazz.isAnnotationPresent(annotation)){
                    //将目标类本省作为key,目标类的实例作为值，放入到beanMap当中。
                    beanMap.put(clazz,ClassUtil.newInstance(clazz,true));
                }
            }
        }
        loaded = true;
    }

}
