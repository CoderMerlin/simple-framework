package com.cp.service.combine.impl;

import com.cp.entity.DTO.MainPageInfoDTO;
import com.cp.entity.DTO.Result;
import com.cp.entity.bo.HeadLine;
import com.cp.entity.bo.ShopCategory;
import com.cp.service.combine.HeadLineShopCategoryCombineService;
import com.cp.service.solo.HeadLineService;
import com.cp.service.solo.ShopCategoryService;
import org.simpleframework.core.annotation.Service;
import org.simpleframework.inject.annotation.Autowired;

import java.util.List;

/**
 * @author Coder编程
 * @Title: HeadLineShopCategoryCombineServiceImpl
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/4/16 16:03
 */
@Service
public class HeadLineShopCategoryCombineServiceImpl implements HeadLineShopCategoryCombineService {

    @Autowired
    private HeadLineService headLineService;

    @Autowired
    private ShopCategoryService shopCategoryService;

    @Override
    public Result<MainPageInfoDTO> getMainPageInfo() {
        //1.获取头条列表
        HeadLine headLineCondition = new HeadLine();
        headLineCondition.setEnableStatus(1);

        Result<List<HeadLine>> headLineResult = headLineService.queryListHeadLine(headLineCondition, 1, 100);
        //2.获取店铺类别列表
        ShopCategory shopCategoryCondition = new ShopCategory();
        Result<List<HeadLine>> shopCategoryResult = shopCategoryService.queryListShopCategory(shopCategoryCondition, 1, 100);
        //3.合并两者并返回
        Result<MainPageInfoDTO> result = mergeMainPageInfoResult(headLineResult,shopCategoryResult);
        return result;
    }

    private Result<MainPageInfoDTO> mergeMainPageInfoResult(Result<List<HeadLine>> headLineResult, Result<List<HeadLine>> shopCategoryResult) {
        return null;
    }
}
