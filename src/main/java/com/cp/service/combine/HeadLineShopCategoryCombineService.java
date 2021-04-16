package com.cp.service.combine;

import com.cp.entity.DTO.MainPageInfoDTO;
import com.cp.entity.DTO.Result;

/**
 * @author Coder编程
 * @Title: HeadLineShopCategoryService
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/4/16 15:59
 */
public interface HeadLineShopCategoryCombineService {

    /**
     * 获取主页信息
     * @return
     */
    Result<MainPageInfoDTO> getMainPageInfo();
}
