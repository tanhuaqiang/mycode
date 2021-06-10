package com.daling.util;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tanhq
 * 合同编号工具类
 */
public class NumberUtil {

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


    private static String numberFormat(Integer numberOne, Integer numberTwo) {
        DecimalFormat df = new DecimalFormat("0.00");
        double result = numberTwo > 0 ? (float)(numberOne - numberTwo) / (float)numberTwo * 100 : 0;
        return df.format(result);

    }

    /**
     * 四舍五入
     * BigDecimal.setScale()方法用于格式化小数点
     * setScale(1)表示保留一位小数，默认用四舍五入方式 
     * setScale(1,BigDecimal.ROUND_DOWN)直接删除多余的小数位，如2.35会变成2.3 
     * setScale(1,BigDecimal.ROUND_UP)进位处理，2.35变成2.4 
     * setScale(1,BigDecimal.ROUND_HALF_UP)四舍五入，2.35变成2.4
     *
     * setScaler(1,BigDecimal.ROUND_HALF_DOWN)四舍五入，2.35变成2.3，如果是5则向下舍
     *
     * setScaler(1,BigDecimal.ROUND_CEILING)接近正无穷大的舍入
     *
     * setScaler(1,BigDecimal.ROUND_FLOOR)接近负无穷大的舍入，数字>0和ROUND_UP作用一样，数字<0和ROUND_DOWN作用一样
     *
     * setScaler(1,BigDecimal.ROUND_HALF_EVEN)向最接近的数字舍入，如果与两个相邻数字的距离相等，则向相邻的偶数舍入。
     * ————————————————
     * 版权声明：本文为CSDN博主「killer-leon」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/u011627980/article/details/79729270
     * @param numberOne
     * @param numberTwo
     * @return
     */
    private static String  numberFormat2(Integer numberOne, Integer numberTwo) {
        double num = numberTwo > 0 ? (double)(numberOne - numberTwo) / (double)numberTwo * 100 : 0;
        BigDecimal b = new BigDecimal(num);
        return String.valueOf(b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());

    }

    private static String percent(Integer numberOne, Integer numberTwo) {
        double num = numberTwo > 0 ? (double)numberOne / (double)numberTwo * 100 : 0;
        BigDecimal bg = new BigDecimal(num);
        return String.valueOf(bg.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
    }

    public static Double numberFormat(Object numberOne, Object numberTwo) {
        if(!isNumber(numberOne) || !isNumber(numberTwo)) {
            throw new RuntimeException("计算增量百分比入参格式不正确");
        }
        Double numberOneDouble = Double.parseDouble(numberOne.toString());
        Double numberTwoDouble = Double.parseDouble(numberTwo.toString());


        double num = numberTwoDouble > 0 ? (numberOneDouble - numberTwoDouble) / numberTwoDouble * 100 : 0;
        BigDecimal bg = BigDecimal.valueOf(num);
        return bg.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 计算增量百分比
     * scale保留小数位数
     * */
    public static Double percentNumber(Object numberOne, Object numberTwo, Integer scale) {
        if(!isNumber(numberOne) || !isNumber(numberTwo)) {
            throw new RuntimeException("计算增量百分比入参格式不正确");
        }

        Double numberOneDouble = Double.parseDouble(numberOne.toString());
        Double numberTwoDouble = Double.parseDouble(numberTwo.toString());

        double num = numberTwoDouble > 0 ? numberOneDouble / numberTwoDouble * 100 : 0;
        return retainDecimal(num, scale);
    }

    /**
     * Double类型截取小数（采用四舍五入）
     * */
    public static Double retainDecimal(Double originNum, Integer scale) {
        BigDecimal bg = BigDecimal.valueOf(originNum);
        return bg.setScale(scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    public static boolean isNumber (Object obj) {
        if (obj instanceof Number) {
            return true;
        } else if (obj instanceof String){
            try{
                Double.parseDouble((String)obj);
                return true;
            }catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    /**
     * 判断Double是否有小数部分
     */
    public static boolean isHasDecimal(Double value) {
        double eps = 1e-10;
        boolean result = value - Math.floor(value) >= eps;
        return result;
    }


    public static void main(String[] args) {
        System.out.println(numberFormat(23, 99));
        System.out.println(numberFormat(23, 0));
        System.out.println(numberFormat(23, 17));
        System.out.println(numberFormat(23, 17888));
        System.out.println("------------------");
        System.out.println(numberFormat2(23, 99));
        System.out.println(numberFormat2(23, 0));
        System.out.println(numberFormat2(23, 17));
        System.out.println(numberFormat2(23, 17888));


        Map<Long, Map<String, Object>> mapMap = Maps.newHashMap();
        Map<String, Object> map = new HashMap<>();
        map.put("lastDayCommentCount", 23);
        map.put("lastWeekCommentCount", 32);
        map.put("lastDayCommentRatio", -76.78);
        map.put("lastWeekCommentRatio", -9.66);

        //好评率
        map.put("lastDayPraiseCount", 32);
        map.put("lastWeekPraiseCount", 53);
        map.put("lastDayPraiseRatio", 9.23);
        map.put("lastWeekPraiseRatio", -5.32);
        mapMap.put(23232L, map);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("lastDayCommentCount", 23);
        map2.put("lastWeekCommentCount", 32);
        map2.put("lastDayCommentRatio", -76.78);
        map2.put("lastWeekCommentRatio", -9.66);

        //好评率
        map2.put("lastDayPraiseCount", 32);
        map2.put("lastWeekPraiseCount", 53);
        map2.put("lastDayPraiseRatio", 9.23);
        map2.put("lastWeekPraiseRatio", -5.32);
        mapMap.put(876111L, map2);
        System.out.println(JSON.toJSON(mapMap));


        System.out.println(percent(22, 100));
        System.out.println(percent(227, 1290));
        System.out.println(percent(23, 56));
    }
}
