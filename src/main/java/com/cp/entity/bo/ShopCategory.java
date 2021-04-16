package com.cp.entity.bo;

import lombok.Data;

import java.util.Date;

/**
 * @author Administrator
 * @Title: ShopCategory
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/4/16 10:44
 */
@Data
public class ShopCategory {

    private Long shopCategoryId;
    private String shopCategoryName;
    private String shopCategoryDesc;
    private String shopCategoryImg;
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;
    private ShopCategory parent;
}
