package org.simpleframework.util;

import java.util.Collection;

/**
 * @author Coder编程
 * @Title: ValidataUtil
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/5/6 18:07
 */

public class ValidationUtil {

    /**
     * String是否为null 或者 ""
     *
     * @param obj：String
     * @return 是否为空
     */
    public static boolean isEmpty(String obj) {
        return (obj == null || "".equals(obj));
    }


    /**
     * Array 是否为null 或者size为0
     * @param objs：Array
     * @return 是否为空
     */
    public static boolean isEmpty(Object[] objs) {
        return objs == null || objs.length == 0;
    }

    /**
     * Collection 是否为null 或者 size为0
     * @param collection 集合
     * @return 是否为空
     */
    public static boolean isEmpty(Collection<?> collection){
        return collection == null || collection.isEmpty();
    }
}
