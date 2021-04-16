package com.cp.service.solo.impl;

import com.cp.entity.DTO.Result;
import com.cp.entity.bo.HeadLine;
import com.cp.entity.bo.ShopCategory;
import com.cp.service.solo.ShopCategoryService;

import java.util.List;

/**
 * @author Coder编程
 * @Title: ShopCategoryServiceImpl
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/4/16 15:59
 */
public class ShopCategoryServiceImpl implements ShopCategoryService {
    @Override
    public Result<Boolean> addShopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<Boolean> removeShopCategory(int shopCategoryId) {
        return null;
    }

    @Override
    public Result<Boolean> modifyShopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<HeadLine> queryShopCategoryById(int shopCategoryId) {
        return null;
    }

    @Override
    public Result<List<HeadLine>> queryListShopCategory(ShopCategory shopCategoryCondition, int pageIndex, int pageSize) {
        return null;
    }
}
