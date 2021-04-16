package com.cp.service.solo;

import com.cp.entity.DTO.Result;
import com.cp.entity.bo.HeadLine;

import java.util.List;

/**
 * @author Coder编程
 * @Title: HeadLineService
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/4/16 15:50
 */
public interface HeadLineService {

    /**
     * 添加
     * @param headLine
     * @return
     */
    Result<Boolean> addHeadLine(HeadLine headLine);

    /**
     * 删除
     * @param headLineId
     * @return
     */
    Result<Boolean> removeHeadLine(int headLineId);

    /**
     * 修改
     * @param headLine
     * @return
     */
    Result<Boolean> modifyHeadLine(HeadLine headLine);

    /**
     * 通过Id查询
     * @param headLineId
     * @return
     */
    Result<HeadLine> queryHeadLineById(int headLineId);

    /**
     * 查询列表
     * @param headLineCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    Result<List<HeadLine>> queryListHeadLine(HeadLine headLineCondition,int pageIndex,int pageSize);

}
