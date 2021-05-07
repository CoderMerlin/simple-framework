package org.simpleframework.core;

import com.cp.controller.DisPatcherServlet;
import com.cp.controller.frontend.MainPageController;
import com.cp.service.solo.HeadLineService;
import com.cp.service.solo.impl.HeadLineServiceImpl;
import org.junit.jupiter.api.*;
import org.simpleframework.core.annotation.Controller;

/**
 * @author Coder编程
 * @Title: BeanContainerTest
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/5/7 10:10
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BeanContainerTest {

    private static BeanContainer beanContainer;

    @BeforeAll
    static void init(){
        beanContainer = BeanContainer.getInstance();
    }


    @DisplayName("加载目标类以及其实例到BeanContainer：loadBeansTest")
    @Test
    @Order(1)
    public void loadBeansTest(){
        Assertions.assertEquals(false,beanContainer.isLoaded());
        beanContainer.loadBeans("com.cp");
        Assertions.assertEquals(6,beanContainer.size());
        Assertions.assertEquals(true,beanContainer.isLoaded());
    }

    @Test
    @Order(2)
    @DisplayName("根据类获取其实例：getBeanTest")
    public void getBeanTest(){
        MainPageController mainPageController = (MainPageController) beanContainer.getBean(MainPageController.class);
        Assertions.assertEquals(true,mainPageController instanceof MainPageController);


        DisPatcherServlet disPatcherServlet = (DisPatcherServlet) beanContainer.getBean(DisPatcherServlet.class);
        Assertions.assertEquals(false,disPatcherServlet instanceof DisPatcherServlet);

    }

    @Test
    @Order(3)
    @DisplayName("根据注解获取实例：getClassesByAnnotationTest")
    public void getClassesByAnnotationTest(){
        Assertions.assertEquals(true,beanContainer.isLoaded());

        Assertions.assertEquals(3,beanContainer.getClassesByAnnotation(Controller.class).size());
    }

    @Test
    @Order(4)
    @DisplayName("根据接口获取实例类：getClassesBySuperTest")
    public void getClassesBySuperTest(){
        Assertions.assertEquals(true,beanContainer.isLoaded());

        Assertions.assertEquals(true,beanContainer.getClassesBySuper(HeadLineService.class).contains(HeadLineServiceImpl.class));
    }

}
