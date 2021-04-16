package com.cp.controller.superadmin;

import com.cp.entity.DTO.Result;
import com.cp.entity.bo.HeadLine;
import com.cp.entity.bo.ShopCategory;
import com.cp.service.solo.ShopCategoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Coder编程
 * @Title: ShopCategoryOperationController
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/4/16 18:26
 */
public class ShopCategoryOperationController {

    private ShopCategoryService shopCategoryService;

    /**
     * 添加
     * @param request
     * @param response
     * @return
     */
    public Result<Boolean> addShopCategory(HttpServletRequest request, HttpServletResponse response){
        //TODO 参数化校验以及请求参数化转换
        return shopCategoryService.addShopCategory(new ShopCategory());
    }

    /**
     * 删除
     * @param request
     * @param response
     * @return
     */
    public Result<Boolean> removeShopCategory(HttpServletRequest request, HttpServletResponse response){
        //TODO 参数化校验以及请求参数化转换
        return shopCategoryService.removeShopCategory(1);
    }

    /**
     * 修改
     * @param request
     * @param response
     * @return
     */
    public Result<Boolean> modifyShopCategory(HttpServletRequest request, HttpServletResponse response){
        //TODO 参数化校验以及请求参数化转换
        return shopCategoryService.modifyShopCategory(new ShopCategory());
    }

    /**
     * 通过Id查询
     * @param request
     * @param response
     * @return
     */
    public Result<HeadLine> queryShopCategoryById(HttpServletRequest request, HttpServletResponse response){
        //TODO 参数化校验以及请求参数化转换
        return shopCategoryService.queryShopCategoryById(1);
    }

    /**
     * 查询列表
     * @param request
     * @param response
     * @return
     */
    public Result<List<HeadLine>> queryListShopCategory(HttpServletRequest request, HttpServletResponse response){
        //TODO 参数化校验以及请求参数化转换
        return shopCategoryService.queryListShopCategory(new ShopCategory(),1,100);
    }
}
