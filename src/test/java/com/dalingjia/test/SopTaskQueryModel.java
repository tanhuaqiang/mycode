/*
 * Copyright (c) 2010-2015 meituan.com
 * All rights reserved.
 *
 */
package com.dalingjia.test;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 查询task接口
 *
 * @author jiangxu
 * @version 1.0
 * @created 2015-12-12
 */
@ApiModel("任务查询参数封装")
@Data
public class SopTaskQueryModel {
    /**
     * 任务类型对应的人,如userId=72003用户发起的任务
     * 与参数 {@code orgId} 二选一
     */
    @ApiModelProperty(value = "用户Id")
    private Integer userId;

    /**
     * 任务类型对应的组织,如orgId=1855下的人发起的任务
     * 与参数 {@code userId} 二选一
     */
    @ApiModelProperty(value = "组织id")
    private Integer orgId;

    /**
     * 任务的id,搜索条件
     */
    @ApiModelProperty(value = "任务Id")
    private Integer taskId;

    /**
     * 任务的名称,搜索条件
     */
    @ApiModelProperty(value = "任务名称")
    private String taskName;

    /**
     * 任务ID列表
     */
    @ApiModelProperty(value = "任务ID列表")
    private List<Integer> taskIdList;

    /**
     * 任务类型,1-发起,2-管理,3-负责
     */
    @NotNull(message = "没有设置任务类型")
    @ApiModelProperty(value = "任务类型")
    private Integer taskType;

    /**
     * 1-已发布 2-已暂停
     */
    @ApiModelProperty(value = "任务状态")
    private Integer taskStatus;

    /**
     * 任务来源 1-酒店 2-度假 3-民宿
     *
     */
    @ApiModelProperty(value = "业务类型 1 酒店 2度假 3民宿")
    private Integer taskSource;

    /**
     * 经办人组织,o123 or u1233
     */
    @ApiModelProperty(value = "经办人涉及组织")
    private List<String> orgIdList;

    /**
     * 任务优先级,已经废弃
     */
    @ApiModelProperty(hidden = true, notes = "任务优先级;不再使用")
    private Integer taskLevel;

    /** 过滤审批中 1表示过滤 */
    @ApiModelProperty(value = "过滤审批中 1表示过滤")
    private Integer filterApproving;

    /**
     * 标签的id列表,如酒店的NCAPE
     */
    @ApiModelProperty(value = "任务标签列表")
    private List<Integer> taskTagList;

    @ApiModelProperty(value = "反馈项类型 1-单结果反馈项 2-信息收集 3-自主提报")
    private Integer handleType;

    @ApiModelProperty(value = "任务类型 1-流转校验型(高阶任务) 2-信息收集(简版任务) 3-自主提报任务")
    private Integer taskStructureType;

    /** 销售等级 */
    @ApiModelProperty(value = "销售等级")
    private Integer bdLevel;

    /** 时间标签 */
    @ApiModelProperty(value = "时间标签")
    private Integer dateLabel;

    /** 组织ID列表 */
    @ApiModelProperty(value = "组织ID列表")
    private List<Integer> orgIds;

    /** 页码 */
    @ApiModelProperty(value = "页码")
    private Integer pageNo;

    /** 页面元素个数 */
    @ApiModelProperty(value = "页面元素个数")
    private Integer pageSize;

    /** 审批状态 */
    @ApiModelProperty("审批状态【USABLE(1,\"未提交\"),APPROVING(2,\"审批中\"),REJECTED(3,\"驳回\"),WITHDRAW(4,\"已撤回\")】")
    private Integer approveStatus;

    @ApiModelProperty("任务扩展类型（1-默认；2-自动化考核任务）")
    private Integer taskExtendType;

    private static final int DEFAULT_PAGE_NO = 1;
    private static final int DEFAULT_PAGE_SIZE = 20;

    public void justInCasePageIsEmpty() {
        if (pageNo == null || pageSize == null) {
            this.pageNo = DEFAULT_PAGE_NO;
            this.pageSize = DEFAULT_PAGE_SIZE;
        }
    }

    public static void main(String[] args) {
        SopTaskQueryModel sopTaskQueryModel = new SopTaskQueryModel();
        sopTaskQueryModel.justInCasePageIsEmpty();
        Integer pageNo = sopTaskQueryModel.getPageNo();
        Integer pageSize = sopTaskQueryModel.getPageSize();

        SaasTaskListModel.buildEmptyModel(pageNo, pageSize);
    }
}
