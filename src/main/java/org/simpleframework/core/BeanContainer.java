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
import java.util.*;
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

    /**
     * 添加一个Class对象以及Bean实例
     * @param clazz：Class对象
     * @param bean：Bean实例
     * @return： 原有的Bean实例，没有则返回null
     */
    public Object addBean(Class<?> clazz,Object bean){
        return beanMap.put(clazz,bean);
    }


    /**
     * 移除一个IOC容器管理的Bean实例
     * @param clazz：Class对象
     * @return：删除的Bean实例，没有则返回null
     */
    public Object removeBean(Class<?> clazz){
        return beanMap.remove(clazz);
    }

    /**
     * 根据Class对象获取Bean实例
     * @param clazz：Class对象
     * @return：Bean实例
     */
    public Object getBean(Class<?> clazz){
        return beanMap.get(clazz);
    }

    /**
     * 获取容器管理的所有Class对象集合
     * @return
     */
    public Set<Class<?>> getClasses(){
        return beanMap.keySet();
    }

    /**
     * 获取所有Bean集合
     * @return：Bean集合
     */
    public Set<Object> getBeans(){
        return new HashSet<>(beanMap.values());
    }

    /**
     * 根据注解筛选出Bean的Class集合
     * @param annotation：注解
     * @return：Class集合
     */
    public Set<Class<?>> getClassesByAnnotation(Class<? extends Annotation> annotation){
        //1.获取beanMap的所有Class对象
        Set<Class<?>> keySet = getClasses();
        if(ValidationUtil.isEmpty(keySet)){
            log.warn("nothing in beanMap");
            return null;
        }
        //2.通过注解筛选被注解标记的Class对象，并添加到classSet里
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?>  clazz: keySet) {
            //类是否有相关的注解标记
            if(clazz.isAnnotationPresent(annotation)){
                classSet.add(clazz);
            }
        }
        return classSet.size() > 0 ? classSet : null;
    }

    /**
     * 通过接口或者弗雷获取实现类或者子类的Class集合，不包括其本身
     * @param interfaceOrClass：接口类或者父类Class
     * @return：Class集合
     */
    public Set<Class<?>> getClassesBySuper(Class<?> interfaceOrClass){
        //1.获取beanMap的所有Class对象
        Set<Class<?>> keySet = getClasses();
        if(ValidationUtil.isEmpty(keySet)){
            log.warn("nothing in beanMap");
            return null;
        }
        //2.通过注解筛选被注解标记的Class对象，并添加到classSet里
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?>  clazz: keySet) {
            //判断keySet里元素是否是传入的接口或者类的子类
            if(interfaceOrClass.isAssignableFrom(clazz)){
                classSet.add(clazz);
            }
        }
        return classSet.size() > 0 ? classSet : null;
    }
}
