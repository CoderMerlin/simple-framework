package org.simpleframework.inject;

import com.cp.controller.frontend.MainPageController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.simpleframework.core.BeanContainer;
import org.simpleframework.inject.annotation.DependencyInjector;

/**
 * @author Coder编程
 * @Title: DependencyInjectorTest
 * @ProjectName simple-framework
 * @Description: 依赖注入测试
 * @date 2021/5/7 16:56
 */
public class DependencyInjectorTest {

    @DisplayName("依赖注入ioc")
    @Test
    public void doIocTest(){
        BeanContainer beanContainer = BeanContainer.getInstance();
        beanContainer.loadBeans("com.cp");

        Assertions.assertEquals(true,beanContainer.isLoaded());

        MainPageController mainPageController = (MainPageController) beanContainer.getBean(MainPageController.class);
        Assertions.assertEquals(true,mainPageController instanceof MainPageController);

        Assertions.assertEquals(null,mainPageController.getHeadLineShopCategoryCombineService());

        new DependencyInjector().doIoc();

        Assertions.assertNotEquals(null, mainPageController.getHeadLineShopCategoryCombineService());

    }
}
