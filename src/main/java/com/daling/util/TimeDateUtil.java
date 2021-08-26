package com.daling.util;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.BooleanUtils;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

public class TimeDateUtil {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter FORMATTER_MIN = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter HOUR = DateTimeFormatter.ofPattern("HH:mm");
    private static final DateTimeFormatter HOUR_MIN = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final ZoneId ZONE_ID = ZoneId.systemDefault();

    /**
     * 10:00的格式按当天转为LocalDate
     *
     * @param time 10:00
     * @return
     */
    public static LocalDateTime time2DateTime(String time) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String endTimeStr = String.format("%s %s", localDateTime.format(DATE_FORMATTER), time);
        LocalDateTime dateTime = LocalDateTime.parse(endTimeStr, FORMATTER);
        return dateTime;
    }

    /**
     * LocalDate转为10:00
     *
     * @param dateTime
     * @return
     */
    public static String dateTime2Time(LocalDateTime dateTime) {
        return dateTime.format(HOUR);
    }

    /**
     * LocalDate转为10:00:00
     *
     * @param dateTime
     * @return
     */
    public static String dateTime2MinSec(LocalDateTime dateTime) {
        return dateTime.format(HOUR_MIN);
    }

    /**
     * 10:00的格式按当天转为LocalDate
     *
     * @param time 10:00
     * @return
     */
    public static LocalDateTime time2DateHHmm(String time) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String endTimeStr = String.format("%s %s", localDateTime.format(DATE_FORMATTER), time);
        if (time.length() > 5) {
            return LocalDateTime.parse(endTimeStr, FORMATTER);
        }
        return LocalDateTime.parse(endTimeStr, FORMATTER_MIN);
    }

    /***
     *
     * @return
     */
    public static long betweenMin(LocalDateTime begin, LocalDateTime end) {
        long seconds = Duration.between(begin, end).getSeconds();
        long l = seconds % 60;
        if (l >= 0) {
            seconds += (60 - l);
        }
        return seconds / 60;
    }

    public static Date from(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        Instant instant = localDateTime.atZone(ZONE_ID).toInstant();
        return Date.from(instant);
    }

    public static LocalDateTime toDT(Date date) {
        if (date == null) {
            return null;
        }
        return LocalDateTime.ofInstant(date.toInstant(), ZONE_ID);
    }

    /**
     * 判断当前时间是否在时间段内
     *
     * @param start
     * @param end
     * @return
     */
    public static boolean isNowBetween(LocalDateTime start, LocalDateTime end) {
        LocalDateTime now = LocalDateTime.now();
        if ((now.isAfter(start) || now.isEqual(start)) && (now.isBefore(end) || now.isEqual(end))) {
            return true;
        }
        return false;
    }

    /**
     * 判断TIME是否在时间段内
     *
     * @param start
     * @param end
     * @return
     */
    public static boolean isBetween(LocalDateTime time, LocalDateTime start, LocalDateTime end) {
        if ((time.isAfter(start) || time.isEqual(start)) && (time.isBefore(end) || time.isEqual(end))) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Map<Integer, Boolean> openSwitchMap = Maps.newHashMap();
        Boolean aBoolean = openSwitchMap.get(323232) != null && BooleanUtils.isTrue(openSwitchMap.get(2323));
        System.out.println(aBoolean);
    }
}
