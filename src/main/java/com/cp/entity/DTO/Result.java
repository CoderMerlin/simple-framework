package com.cp.entity.DTO;

import lombok.Data;

/**
 * @author Coder编程
 * @Title: Result
 * @ProjectName simple-framework
 * @Description: TODO
 * @date 2021/4/16 15:35
 */
@Data
public class Result<T> {

    /**本次请求结果的状态码。200表示成功*/
    private int code;

    /**本次请求结果的详情*/
    private String msg;

    /**本次请求返回的结果集*/
    private T data;

}
