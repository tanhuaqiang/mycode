package com.dalingjia.util.timeUtil;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TimeTest {

    static DateTimeFormatter formatterDHM = DateTimeFormat.forPattern("dd_HH_mm");

    static DateTimeFormatter formatterYMDHMS = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    static DateTimeFormatter formatterYMDH = DateTimeFormat.forPattern("yyyyMMddHH");

    private static DateTimeFormatter formatterYM = DateTimeFormat.forPattern("yy_M");

    private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");;
    static {
        //方法一：取系统点间
        DateTime dt1 = new DateTime();
        //方法二：通过java.util.Date对象生成
        DateTime dt2 = new DateTime(new Date());
        //方法三：指定年月日点分秒生成(参数依次是：年,月,日,时,分,秒,毫秒)
        DateTime dt3 = new DateTime(2012, 5, 20, 13, 14, 0, 0);
        //方法四：ISO8601形式生成
        DateTime dt4 = new DateTime("2012-05-20");
        DateTime dt5 = new DateTime("2012-05-20T13:14:00");
        //只需要年月日的时候
        LocalDate localDate = new LocalDate(2009, 9, 6);// September 6, 2009
        //只需要时分秒毫秒的时候
        LocalTime localTime = new LocalTime(13, 30, 26, 0);// 1:30:26PM
    }

    private static String goodShelfGetQueryKey(String goodId){
        String currMin = DateTime.now().toString(formatterDHM);
        return "xc_sale_prod_info_query_" + currMin + "_"+ goodId;
    }

    /**
     * 时间戳转换成日期格式字符串
     * @param time
     * @return
     */
    private static String dateFormat(String time){
        if(StringUtils.isEmpty(time)){
            return "";
        }
        DateTime confirmTime = new DateTime(Long.valueOf(time));
        return confirmTime.toString(formatterYMDHMS);
    }

    private static String timeFormat(Long modiDate){
        if(modiDate == null){
            return "";
        }
        Long twoDay = 2*24*60*60*1000L;
        Long time = modiDate + twoDay - System.currentTimeMillis();
        Long day = time/24/60/60/1000L;
        Long hour = (time- day*24*60*60*1000) / (60*60*1000);
        Long minutes = (time- day*24*60*60*1000 - hour*60*60*1000)/(60*1000);
        Long seconds = (time- day*24*60*60*1000 - hour*60*60*1000 - minutes*60*1000)/1000;
        return day + "天" + hour + "时" + minutes + "分" + seconds + "秒";
    }

    public static void main(String[] args) {
        System.out.println(dateFormat("1551927106433"));
        System.out.println(dateFormat(System.currentTimeMillis()+""));
        System.out.println(timeFormat(1551927106433L));
        System.out.println(goodShelfGetQueryKey("1001"));

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = df.parse("2018-08-01 13:33:33");
            System.out.println(date.before(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String currMin = DateTime.now().toString(formatterYM);
        System.out.println(currMin);
        DateTime dt3 = new DateTime(2019, 12, 20, 13, 14, 0, 0);
        System.out.println(dt3.toString(formatterYM));
    }

    @Test
    public void test1(){
        try {
            Date date1 = df.parse("2018-08-09 21:33:32");
            Date date2 = df.parse("2018-09-09 15:39:52");
            System.out.println(date1.before(date2));
            System.out.println(date1.after(date2));

            //返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数
            System.out.println(date2.getTime() + 2*24*60*60*1000 > new Date().getTime());
            System.out.println(date1.getTime());
            System.out.println(1*24*60*60*1000);
            System.out.println(new Date().getTime());

            System.out.println( new DateTime(date1.getTime()).plusDays(180) );
            System.out.println(new DateTime(date1.getTime()).plusDays(180).isAfter(new Date().getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
        String now = DateTime.now().toString(formatterYMDHMS);
        System.out.println("now = " + now);
        LocalDateTime localDate = formatterYMDHMS.parseLocalDateTime(now);
        System.out.println(localDate);
        System.out.println(DateTime.now());
        boolean flag = new DateTime(DateTime.now()).plusDays(180).isAfter(new Date().getTime());
        System.out.println(flag);
    }


    @Test
    public void test3(){
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        /* HOUR_OF_DAY 指示一天中的小时 */

        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);

        String time = new DateTime(calendar.getTime()).toString(formatterYMDH);

        System.out.println(time);

        String ymd =  new DateTime(new Date()).toString(formatterYMDHMS);
        System.out.println(ymd);
    }

    public static String getYearAndMonthFromString(String date){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(date != null){
            DateTime dateTime = null;
            try {
                dateTime = new DateTime(df.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return dateTime.toString(formatterYM);
        }
        return null;
    }


    @Test
    public void test4(){
        String date = "2019-01-11 13:32:31";
        System.out.println(getYearAndMonthFromString(date));
    }

}
