package com.cp.service.solo;

import com.cp.entity.DTO.Result;
import com.cp.entity.bo.HeadLine;
import com.cp.entity.bo.ShopCategory;

import java.util.List;

/**
 * @author Coder编程
 * @Title: ShopCategoryService
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/4/16 15:51
 */
public interface ShopCategoryService {

    /**
     * 添加
     * @param shopCategory
     * @return
     */
    Result<Boolean> addShopCategory(ShopCategory shopCategory);

    /**
     * 删除
     * @param shopCategoryId
     * @return
     */
    Result<Boolean> removeShopCategory(int shopCategoryId);

    /**
     * 修改
     * @param shopCategory
     * @return
     */
    Result<Boolean> modifyShopCategory(ShopCategory shopCategory);

    /**
     * 通过Id查询
     * @param shopCategoryId
     * @return
     */
    Result<HeadLine> queryShopCategoryById(int shopCategoryId);

    /**
     * 查询列表
     * @param shopCategoryCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    Result<List<HeadLine>> queryListShopCategory(ShopCategory shopCategoryCondition, int pageIndex, int pageSize);
}
