package org.simpleframework.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * @author Coder编程
 * @Title: ClassUtilTest
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/5/6 14:47
 */
public class ClassUtilTest {

    @DisplayName("提取目标类方法：extractPackageClassTest")
    @Test
    public void extractPackageClassTest(){
        Set<Class<?>> classSet = ClassUtil.extractPackageClass("com.cp.entity");
        System.out.println(classSet);
        Assertions.assertEquals(4,classSet.size());
    }
}
