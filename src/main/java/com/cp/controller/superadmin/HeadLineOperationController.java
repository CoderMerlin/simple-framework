package com.cp.controller.superadmin;

import com.cp.entity.DTO.Result;
import com.cp.entity.bo.HeadLine;
import com.cp.service.solo.HeadLineService;
import org.simpleframework.core.annotation.Controller;
import org.simpleframework.inject.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Coder编程
 * @Title: HeadLineOperationController
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/4/16 18:26
 */
@Controller
public class HeadLineOperationController {

    @Autowired
    private HeadLineService headLineService;
    /**
     * 添加
     * @param request
     * @param response
     * @return
     */
    public Result<Boolean> addHeadLine(HttpServletRequest request, HttpServletResponse response){
        //TODO 参数化校验以及请求参数化转换
        return headLineService.addHeadLine(new HeadLine());
    }

    /**
     * 删除
     * @param request
     * @param response
     * @return
     */
    public Result<Boolean> removeHeadLine(HttpServletRequest request, HttpServletResponse response){
        //TODO 参数化校验以及请求参数化转换
        return headLineService.removeHeadLine(1);
    }

    /**
     * 修改
     * @param request
     * @param response
     * @return
     */
    public Result<Boolean> modifyHeadLine(HttpServletRequest request, HttpServletResponse response){
        //TODO 参数化校验以及请求参数化转换
        return headLineService.modifyHeadLine(new HeadLine());
    }

    /**
     * 通过Id查询
     * @param request
     * @param response
     * @return
     */
    public Result<HeadLine> queryHeadLineById(HttpServletRequest request, HttpServletResponse response){
        //TODO 参数化校验以及请求参数化转换
        return headLineService.queryHeadLineById(1);
    }

    /**
     * 查询列表
     * @param request
     * @param response
     * @return
     */
    public Result<List<HeadLine>> queryListHeadLine(HttpServletRequest request, HttpServletResponse response){
        //TODO 参数化校验以及请求参数化转换
        return headLineService.queryListHeadLine(new HeadLine(),1,100);
    }
}
