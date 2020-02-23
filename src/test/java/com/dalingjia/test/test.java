package com.dalingjia.test;

import com.daling.bean.YesNoEnum;
import com.google.common.util.concurrent.RateLimiter;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) {
        Long prodQty = 99L;
        Long aLong = 99L;
        Long erpQty = 33L;
        System.out.println(prodQty.compareTo(erpQty));
        System.out.println(prodQty.compareTo(aLong));
        System.out.println(erpQty.compareTo(aLong));

        StringBuffer str = new StringBuffer();
        str.append("tanqh").append(";").append("xige").append(";");
        System.out.println(str);
        System.out.println(str.length());
//        str.deleteCharAt(str.length() - 1);
        str.deleteCharAt(str.length() - 1);
        System.out.println(str);

        //Guava中开源出来一个令牌桶算法的工具类RateLimiter，可以轻松实现限流的工作
        RateLimiter limiter = RateLimiter.create(50); // 每秒不超过10个任务被提交
        /**
         * 当然也可以使用tryAcquire来非阻塞的获取，可以实时返回结果。
         * 另外tryAcquire也可以传入参数，也就是等待的时间，超时直接返回false。这点等同于常见的lock，tryLock
         */
        limiter.tryAcquire();


        BigDecimal exclVatAmount = BigDecimal.ONE;
        BigDecimal tax = BigDecimal.ZERO;
        System.out.println(tax.compareTo(BigDecimal.ZERO) == 0);
        System.out.println(tax.divide(exclVatAmount));


        String[] s = isOvertime("");
        System.out.println(s[0]);
        System.out.println(s[1]);
        String[] s1 = isOvertime("1");
        String[] s2 = isOvertime(",1");
        String[] s3 = isOvertime("1,0");
        String[] s4 = isOvertime(",1,0");

    }

    private static String[] isOvertime(String isAnswerOvertime) {
        String[] isOvertime = {"", ""};
        if (StringUtils.isNotEmpty(isAnswerOvertime)) {
            List<String> list = new ArrayList<>();
            String[] strings = isAnswerOvertime.split(",");
            for (String str : strings) {
                if (StringUtils.isNotEmpty(str)) {
                    list.add(str);
                }
            }
            if (list.size() >= 2) {
                isOvertime[0] = YesNoEnum.codeOf(Integer.parseInt(list.get(0))).getName();
                isOvertime[1] = YesNoEnum.codeOf(Integer.parseInt(list.get(1))).getName();
            }else {
                isOvertime[0] = YesNoEnum.codeOf(Integer.parseInt(list.get(0))).getName();
            }
        }
        return isOvertime;
    }


}
