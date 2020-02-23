package com.dalingjia.leetcode.string;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author tanhq
 * @Description  1185 一周中的第几天
 * @Date 2019/9/22 下午11:05
 * @Version 1.0
 **/
public class DayOfTheWeek {

    /**
     * 给定年月日，判断这一天是星期几
     * @param day
     * @param month
     * @param year
     * @return
     */
    public static String dayOfTheWeek(int day, int month, int year) {
        String[] str = {"星期日-Sunday", "星期一-Monday", "星期二-Tuesday", "星期三-Wednesday", "星期四-Thursday", "星期五-Friday", "星期六-Saturday"};
        String date = year + "-" + month + "-" + day;
        for (String s : str) {
            String[] strings = s.split("-");
            if (strings[0].equals(getDayOfWeekByDate(date))) {
                return strings[1];
            }
        }
        return "";
    }


    public static String getDayOfWeekByDate(String date) {
        String dayOfweek = "-1";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;
        try {
            d = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat format = new SimpleDateFormat("E");
        return format.format(d);

    }

    public static void main(String[] args) {
        String date = "2019-09-22";
        String date2 = "1971-01-01";
        System.out.println(dayOfTheWeek(31, 8, 2019));
        System.out.println(dayOfTheWeek(18, 7, 1999));
        System.out.println(dayOfTheWeek(15, 8, 1993));
    }
}

 
    
    
    
    