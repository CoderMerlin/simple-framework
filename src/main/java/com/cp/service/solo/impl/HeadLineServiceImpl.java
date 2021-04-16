package com.cp.service.solo.impl;

import com.cp.entity.DTO.Result;
import com.cp.entity.bo.HeadLine;
import com.cp.service.solo.HeadLineService;

import java.util.List;

/**
 * @author Coder编程
 * @Title: HeadLineServiceImpl
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/4/16 15:58
 */
public class HeadLineServiceImpl implements HeadLineService {
    @Override
    public Result<Boolean> addHeadLine(HeadLine headLine) {
        return null;
    }

    @Override
    public Result<Boolean> removeHeadLine(int headLineId) {
        return null;
    }

    @Override
    public Result<Boolean> modifyHeadLine(HeadLine headLine) {
        return null;
    }

    @Override
    public Result<HeadLine> queryHeadLineById(int headLineId) {
        return null;
    }

    @Override
    public Result<List<HeadLine>> queryListHeadLine(HeadLine headLineCondition, int pageIndex, int pageSize) {
        return null;
    }
}
