package com.daling.util;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * @author damon
 * @version 2019/5/6
 */
public final class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String HH_MM = "HH:mm";

    private DateUtils() {
    }

    /**
     * 将Date转换为LocalDateTime
     *
     * @param date 目标日期
     * @return 结果日期
     */
    public static LocalDateTime ofLocalDateTime(Date date) {
        if (Objects.isNull(date)) {
            return null;
        }

        ZoneId zoneId = ZoneId.systemDefault();
        return date.toInstant().atZone(zoneId).toLocalDateTime();
    }

    /**
     * 将LocalDateTime转换为Date
     *
     * @param localDateTime 目标日期
     * @return 结果日期
     */
    public static Date ofDate(LocalDateTime localDateTime) {
        if (Objects.isNull(localDateTime)) {
            return null;
        }

        ZoneId zoneId = ZoneId.systemDefault();
        return Date.from(localDateTime.atZone(zoneId).toInstant());
    }

    /**
     * 格式化日期，并转换为字符串
     *
     * @param date    目标日期
     * @param pattern 格式
     * @return 字符串
     */
    public static String format(Date date, String pattern) {
        if (Objects.isNull(date)) {
            return null;
        }

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return ofLocalDateTime(date).format(dateTimeFormatter);
    }

    /**
     * 格式化日期，并转换为字符串
     *
     * @param date    目标日期
     * @param pattern 格式
     * @return 字符串
     */
    public static String format(long date, String pattern) {
        if (Objects.isNull(date)) {
            return null;
        }

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return ofLocalDateTime(new Date(date)).format(dateTimeFormatter);
    }

    /**
     * 将字符串按照指定格式转换为日期
     *
     * @param date    日期字符串
     * @param pattern 格式
     * @return 日期
     */
    public static Date parse(String date, String pattern) {
        if (StringUtils.isEmpty(date)) {
            return null;
        }

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        if (YYYY_MM_DD.equals(pattern) || YYYYMMDD.equals(pattern)) {
            return ofDate(LocalDateTime.of(LocalDate.parse(date, dateTimeFormatter), LocalTime.MIN));
        }
        return ofDate(LocalDateTime.parse(date, dateTimeFormatter));
    }

    public static long unixLongTime() {
        return date2UnixTimeSec(new Date());
    }

    public static long date2UnixTimeSec(Date date) {
        return Objects.isNull(date) ? null : date.getTime() / 1000L;
    }

    /**
     * 获取周第一天
     *
     * @param localDate  日期
     * @param weeksToAdd 偏移周数
     * @return 第一天
     */
    public static String firstDayOfWeek(LocalDate localDate, int weeksToAdd) {
        return localDate.plusWeeks(weeksToAdd).with(DayOfWeek.MONDAY).toString();
    }

    /**
     * 获取周最后一天
     *
     * @param localDate  日期
     * @param weeksToAdd 偏移周数
     * @return 最后一天
     */
    public static String lastDayOfWeek(LocalDate localDate, int weeksToAdd) {
        return localDate.plusWeeks(weeksToAdd).with(DayOfWeek.SUNDAY).toString();
    }

    /**
     * 获取月第一天
     *
     * @param localDate   日期
     * @param monthsToAdd 偏移月数
     * @return 第一天
     */
    public static String firstDayOfMonth(LocalDate localDate, int monthsToAdd) {
        return localDate.plusMonths(monthsToAdd).with(TemporalAdjusters.firstDayOfMonth()).toString();
    }

    /**
     * 获取月最后一天
     *
     * @param localDate   日期
     * @param monthsToAdd 偏移月数
     * @return 最后一天
     */
    public static String lastDayOfMonth(LocalDate localDate, int monthsToAdd) {
        return localDate.plusMonths(monthsToAdd).with(TemporalAdjusters.lastDayOfMonth()).toString();
    }

    /**
     * 获取一天的最早时刻
     *
     * @param date
     * @param
     * @return
     */
    public static Date firstTimeOfDay(Date date) {
        if (Objects.isNull(date)) {
            return null;
        }

        return ofDate(LocalDateTime.of(ofLocalDateTime(date).toLocalDate(), LocalTime.MIN));
    }

    /**
     * 获取一天的最早时刻
     *
     * @param date
     * @param pattern
     * @return
     */
    public static Date firstTimeOfDay(String date, String pattern) {
        return ofDate(LocalDateTime.of(LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern)), LocalTime.MIN));
    }

    /**
     * 获取一天的最后时刻
     *
     * @param date
     * @return
     */
    public static Date lastTimeOfDay(Date date) {
        if (Objects.isNull(date)) {
            return null;
        }

        return ofDate(LocalDateTime.of(ofLocalDateTime(date).toLocalDate(), LocalTime.MAX));
    }

    /**
     * 获取一天的最后时刻
     *
     * @param date
     * @param pattern
     * @return
     */
    public static Date lastTimeOfDay(String date, String pattern) {
        return ofDate(LocalDateTime.of(LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern)), LocalTime.MAX));
    }

    public static long getTimeStamp(Date date) {
        return date == null ? System.currentTimeMillis() : date.getTime();
    }

    public static Date fromUnixTime(Long millis) {
        return new Date(millis);
    }

    // datetime是否是当前时间num天内
    public static boolean isNumDaysBefore(Date datetime, Date nowTime, Integer num) {
        Date now = new Date();
        if (nowTime != null) {
            now = nowTime;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.DAY_OF_MONTH, -num);
        Date beforeSevenDays = calendar.getTime();
        if (beforeSevenDays.getTime() < datetime.getTime()) {
            return true;
        }
        return false;
    }

    /**
     * 将秒数转换为HH:mm:ss格式的时间，HH不是24小时制
     * <p>
     * 如：25 * 3600 + 3400 + 30返回结果25:57:10
     *
     * @param seconds
     * @return
     */
    public static String secondToTime(Integer seconds) {
        int hour = seconds / 3600;
        int minute = seconds / 60 % 60;
        int second = seconds % 60;
        StringBuilder timeBuilder = new StringBuilder();
        if (0 <= hour && 10 > hour) {
            timeBuilder.append("0");
        }
        timeBuilder.append(hour).append(":");
        if (0 <= minute && 10 > minute) {
            timeBuilder.append("0");
        }
        timeBuilder.append(minute).append(":");
        if (0 <= second && 10 > second) {
            timeBuilder.append("0");
        }
        timeBuilder.append(second);

        return timeBuilder.toString();
    }


    /**
     * 是否超时
     * @param first
     * @param second
     * @param duration
     * @return
     */
    public static boolean isTimeout(Long first, Long second, Integer duration) {
        if (first == null) {
            return true;
        }
        if (first - second > duration * 60 * 1000) {
            return true;
        }
        return false;
    }

    /**
     * 是否已过12点
     * @param time
     * @return
     */
    public static boolean isAfterTwelve(Long time) {
        Calendar calendar = Calendar.getInstance();
        //将小时至12
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        //将分钟至0
        calendar.set(Calendar.MINUTE, 0);
        //将秒至0
        calendar.set(Calendar.SECOND, 0);
        return time >= calendar.getTime().getTime();
    }

    /**
     * 是否是历史日期
     * @param date
     * @return
     */
    public static boolean isHistoryDate(String date) {

        Long time = DateUtils.lastTimeOfDay(date, DateUtils.YYYY_MM_DD).getTime();
        Long today = DateUtils.firstTimeOfDay(new Date()).getTime();
        return time < today;
    }

    /**
     * 2种情况无交集
     * @param oneStartTime
     * @param oneEndTime
     * @param twoStartTime
     * @param twoEndTime
     * @return  true：有交集，false：无交集
     */
    public static boolean timeCross(Long oneStartTime, Long oneEndTime, Long twoStartTime, Long twoEndTime) {
        if (twoEndTime <= oneStartTime || twoStartTime >= oneEndTime) {
            return false;
        }
        return true;
    }

    /**
     * 获取日期向前或向后diff天的日期
     *
     * @param date    目标日期
     * @param diff    正数表示向后天数，负数表示向前天数
     * @return 结果日期
     */
    public static Date getPlusDate(Date date, int diff) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, diff);//把日期增加/减少diff天.正数往后推,负数往前移
        return calendar.getTime();
    }

    /**
     * 指定日期当天的00:00:00
     *
     * @author lichengwu
     */
    public static Date toFirstSecond(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 指定日期当天的最后一秒 上面的方法toLastSecond返回的时间插入库后变成下一天0s了
     */
    public static Date lastSecond(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }


    public static Integer getDateByNumber(Integer date, Integer number) {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        try {
            Date parse = df.parse(String.valueOf(date));
            String format = df.format(getPlusDate(parse, number));
            return Integer.valueOf(format);
        } catch (ParseException e) {

        }
        return null;
    }

    public static Integer formatDate(Date date) {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        String format = df.format(date);
        return Integer.valueOf(format);
    }

    public static String formatTime(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return df.format(date);
    }

    private static String dataUpdateTime(Date date) {
        if (date == null) {
            return "";
        }
        Date startTime = DateUtils.toFirstSecond(DateUtils.getPlusDate(date, -7));
        Date endTime = DateUtils.lastSecond(DateUtils.getPlusDate(date, -1));
        return DateUtils.formatTime(startTime) + "-" + DateUtils.formatTime(endTime);
    }

    public static void main(String[] args) {
        System.out.println(getDateByNumber(20210513, -1));
        System.out.println(getDateByNumber(20210513, 1));
        System.out.println(getDateByNumber(20210501, -1));
        System.out.println(getDateByNumber(20210501, 2));
        System.out.println(getDateByNumber(20210501, -2));

        System.out.println(formatDate(new Date()));
        System.out.println(dataUpdateTime(new Date()));
    }
}
