package com.dalingjia.test;

import lombok.Data;

import java.util.List;

@Data
public class MerchantExtensionDto {

    private List<MerchantExtensionBo> merchantExtensionBoList;

    private Long total;
    
}