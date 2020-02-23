package com.daling.util;

import org.joda.time.DateTime;

/**
 * @author tanhq
 * 合同编号工具类
 */
public class ContractNumberUtil {

    private static final String DAT_FMT_STR = "yyyyMMddHHmmss";

    /**
     *  年月日小时分秒+3位顺序流水号+1位数字校验码
     */
    public static String genContractNumber() {
        String idx000 = N000IdxLocalGener.getInstance().getNextIndexString();
        String timeStr = DateTime.now().toString(DAT_FMT_STR);
        String str = timeStr + idx000;
        char luhnChar = DigitCharVerifyTools.ISO7812_Luhn_Generate(str.toCharArray());

        return new String(str + luhnChar);
    }


}
