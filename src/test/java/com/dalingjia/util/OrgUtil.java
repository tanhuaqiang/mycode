package com.dalingjia.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class OrgUtil {

    public static void main(String[] args) {
        String ss = "公司-美团-到店事业群-餐饮SaaS事业部-销售部-直营销售组-东部大区-华北区域";
        String[] split = ss.split("-");
        String[] copyOfRange = Arrays.copyOfRange(split, 5, split.length);
        System.out.println(StringUtils.join(copyOfRange, "/"));
    }
}
