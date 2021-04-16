package com.cp.entity.DTO;

import com.cp.entity.bo.HeadLine;
import com.cp.entity.bo.ShopCategory;
import lombok.Data;

import java.util.List;

/**
 * @author Coder编程
 * @Title: MainPageInfoDTO
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/4/16 16:02
 */
@Data
public class MainPageInfoDTO {

    private List<HeadLine> headLineList;

    private List<ShopCategory> shopCategoryList;
}
