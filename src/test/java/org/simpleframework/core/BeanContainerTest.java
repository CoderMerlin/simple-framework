package org.simpleframework.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author Coder编程
 * @Title: BeanContainerTest
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/5/7 10:10
 */
public class BeanContainerTest {

    private static BeanContainer beanContainer;

    @BeforeAll
    static void init(){
        beanContainer = BeanContainer.getInstance();
    }


    @Test
    public void loadBeansTest(){
        Assertions.assertEquals(false,beanContainer.isLoaded());
        beanContainer.loadBeans("com.cp");
        Assertions.assertEquals(6,beanContainer.size());
        Assertions.assertEquals(true,beanContainer.isLoaded());
    }
}
