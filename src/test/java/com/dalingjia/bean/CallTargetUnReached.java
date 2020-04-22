package com.dalingjia.bean;


import lombok.Data;

import java.util.Date;

/**
 * @author : tanhq
 * @version :
 * @date : Created in 2020/1/6 下午2:23
 * @description: 电话邀约未达标实体类
 */
@Data
public class CallTargetUnReached {

    private Long id;

    /**
     * 未完成信息，json数组
     */
    private String unFinishedInfo;

    public CallTargetUnReached(Long id, String unFinishedInfo) {
        this.id = id;
        this.unFinishedInfo = unFinishedInfo;
    }

}
