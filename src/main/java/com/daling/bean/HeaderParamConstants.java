package com.daling.bean;

public enum HeaderParamConstants {
    TOKEN("x-token", "请求令牌"),

    TIMESTAMP("x-timestamp", "访问时间"),

    SIGN("x-sign", "签名值"),

    NONCE("x-nonce", "随机数");

    private String key;

    private String desc;

    HeaderParamConstants(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }


    public String getKey() {
        return key;
    }

    public String getDesc() {
        return desc;
    }
}
