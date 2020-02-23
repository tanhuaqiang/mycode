package com.dalingjia.math;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class BigDecimalTest {

    @Test
    public void testBigDecimalTest(){
        DecimalFormat fmt=new DecimalFormat("0.0000");
        BigDecimal i= new BigDecimal(78.3500);
//		BigDecimal g =(i.multiply(new BigDecimal(100)).intValue())/100d;
        int t = i.multiply(new BigDecimal(100)).intValue();
        System.out.println(t);
        System.out.println(fmt.format(i));
        System.out.println(t/100d);

        BigDecimal prodAmount = BigDecimal.ZERO;
        prodAmount = prodAmount.add(new BigDecimal(388.98).multiply(new BigDecimal(10)).setScale(2, BigDecimal.ROUND_HALF_UP));
        System.out.println(prodAmount);
        //保留小数点后两位，4舍5入
        System.out.println(new BigDecimal(388.985).setScale(2, BigDecimal.ROUND_HALF_UP));
        System.out.println(new BigDecimal(388.984).setScale(2, BigDecimal.ROUND_HALF_UP));

        System.out.println(new BigDecimal(93.4842).setScale(2,RoundingMode.HALF_UP));
        System.out.println(new BigDecimal(93.4852).setScale(2,RoundingMode.HALF_UP));
    }
}
