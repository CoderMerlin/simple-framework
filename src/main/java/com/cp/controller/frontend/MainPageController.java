package com.cp.controller.frontend;

import com.cp.entity.DTO.MainPageInfoDTO;
import com.cp.entity.DTO.Result;
import com.cp.service.combine.HeadLineShopCategoryCombineService;
import lombok.Data;
import org.simpleframework.core.annotation.Controller;
import org.simpleframework.inject.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Coder编程
 * @Title: MainPageController
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/4/16 18:14
 */
@Controller
@Data
public class MainPageController {

    @Autowired("HeadLineShopCategoryCombineServiceImpl")
    private HeadLineShopCategoryCombineService headLineShopCategoryCombineService;

    public Result<MainPageInfoDTO> getMainPageInfo(HttpServletRequest request, HttpServletResponse response){
        return headLineShopCategoryCombineService.getMainPageInfo();
    }
}
