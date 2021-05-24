package com.dalingjia.test;

import lombok.Data;

@Data
public class MerchantExtensionBo {

    /**
     * 租户id
     */
    private Long tenantId;

    /**
     * 门店id
     */
    private Long poiId;

    /**
     * 菜品ID
     */
    private Long spuId;

    /**
     * 菜品名称
     */
    private String spuName;

    private Integer dateKey;

    /**
     * //1-海报，2-广告，3-弹窗
     */
    private Integer channel;

    private Integer uvCnt;

}