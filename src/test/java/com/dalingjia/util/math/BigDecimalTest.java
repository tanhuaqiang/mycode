package com.dalingjia.util.math;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal big = new BigDecimal(10.0000);

        //格式化
        DecimalFormat fmt=new DecimalFormat("0.00");

        Map<String, Object> tempMap = new HashMap<>();

        tempMap.put("shipFee", fmt.format( big==null || big.doubleValue()==0
                ? BigDecimal.ZERO
                :((big.multiply(new BigDecimal(100)).intValue())/100d)));
        tempMap.put("shipFee1", fmt.format( big==null || big.doubleValue()==0
                ? BigDecimal.ZERO
                :big));
        System.out.println("shipFee = " + tempMap.get("shipFee"));
        System.out.println("shipFee1 = " + tempMap.get("shipFee1"));
        //multiply 乘法
        System.out.println(big.multiply(new BigDecimal(100)).intValue()/100d);
        //格式化
        System.out.println(fmt.format(1000));

        BigDecimal tax = new BigDecimal("33.4532");
        BigDecimal taxRate = new BigDecimal("98.8452");
        BigDecimal tax2 = tax.setScale(2, BigDecimal.ROUND_UP);//保留2位小数，并采用进位原则,3也进位
        BigDecimal tax3 = taxRate.setScale(2, BigDecimal.ROUND_HALF_UP);//保留2位小数，4舍5入

//        tax = tax.setScale(2, BigDecimal.ROUND_UP);
        tax = tax.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println("tax=" + tax);
        System.out.println("tax2=" + tax2);
        System.out.println("tax3=" + tax3);
    }
}
