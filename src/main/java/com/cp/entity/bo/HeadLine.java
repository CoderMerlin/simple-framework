package com.cp.entity.bo;

import lombok.Data;

import java.util.Date;



@Data
public class HeadLine {

    private Long lindeId;
    private String lineName;
    private String lineLink;
    private String lineImg;
    private Integer priority;
    private Integer enableStatus;
    private Date createDate;
    private Date lastEditTime;

}
