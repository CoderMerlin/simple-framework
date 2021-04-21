package com.cp.controller;

import com.cp.controller.frontend.MainPageController;
import com.cp.controller.superadmin.HeadLineOperationController;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Coder编程
 * @Title: DisPatcherServlet
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/4/16 16:46
 */
@Slf4j
@WebServlet("/") //拦截所有的请求
public class DisPatcherServlet extends HttpServlet {

    //当servlet匹配到方法后，会调用service方法

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的路径和方法
        log.info("获取请求路径：{}",req.getServletPath());

        log.info("获取请求方法：{}",req.getMethod());
        //根据请求的路径和方法，选择合适的Controller进行处理   //思考：这种写法是不是可以改造呢？
        if(req.getServletPath() == "frontend/getMainPageInfo" && req.getMethod() == "GET"){
            new MainPageController().getMainPageInfo(req,resp);
        } else if(req.getServletPath() == "superadmin/addHeadLine" && req.getMethod() == "POST"){
            new HeadLineOperationController().addHeadLine(req,resp);
        }
    }

}
