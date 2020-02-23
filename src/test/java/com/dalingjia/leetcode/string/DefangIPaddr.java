package com.dalingjia.leetcode.string;

/**
 * @author tanhq
 * @Description  1108 IP地址无效化
 * @Date 2019/9/20 下午10:54
 * @Version 1.0
 **/
public class DefangIPaddr {

    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }
}

 
    
    
    
    