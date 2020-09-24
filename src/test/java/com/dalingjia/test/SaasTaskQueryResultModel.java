package com.dalingjia.test;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author damon
 * @version 2019/7/23
 */
@Data
public class SaasTaskQueryResultModel {

    /**
     * 任务收集项名称
     */
    @ApiModelProperty(value = "任务收集项名称")
    private String feedbackNames;

    /**
     * 下发工单总数
     */
    @ApiModelProperty(value = "下发工单总数")
    private Integer total;
    /**
     * 已处理、已处理率、已处理率格式化后数据
     */
    @ApiModelProperty(value = "已处理")
    private Integer committed;
    @ApiModelProperty(value = "工单已处理率")
    private Double committedRatio;
}
