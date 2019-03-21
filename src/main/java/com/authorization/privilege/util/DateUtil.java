package com.authorization.privilege.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author duxuebo
 * @date 2019/3/20
 * @description 日期工具类
 */
public class DateUtil {

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";


    /**
     * 日期转字符串
     *
     * @param localDateTime 要转换的日期
     * @param style         格式化字符串 使用DateUtil的常量定义形式
     * @return 日期字符串
     */
    public static String date2String(LocalDateTime localDateTime, String style) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(style);
        return localDateTime.format(dtf);
    }



    public static void main(String[] args) {

        LocalDate currentDate = LocalDate.now();
        System.out.println("当前日期为：" + currentDate);
        System.out.println("年：" + currentDate.getYear() + " 月： " + currentDate.getMonthValue() + " 日: " + currentDate.getDayOfMonth());

        System.out.println("一天后的日期为：" + currentDate.plus(1, ChronoUnit.DAYS));
        System.out.println("一周后的日期为：" + currentDate.plus(1, ChronoUnit.WEEKS));
        System.out.println("一月后的日期为：" + currentDate.plus(1, ChronoUnit.MONTHS));
        System.out.println("一年后的日期为：" + currentDate.plus(1, ChronoUnit.YEARS));
        System.out.println("一天前的日期为：" + currentDate.minus(1, ChronoUnit.DAYS));
        System.out.println("一周前的日期为：" + currentDate.minus(1, ChronoUnit.WEEKS));
        System.out.println("一月前的日期为：" + currentDate.minus(1, ChronoUnit.MONTHS));
        System.out.println("一年前的日期为：" + currentDate.minus(1, ChronoUnit.YEARS));

        LocalDate customizedDate = LocalDate.of(2019, 03, 11);
        System.out.println("指定日期是:" + customizedDate);

        System.out.println("比较俩个日期是否相等：" + currentDate.equals(customizedDate));
        System.out.println("比较俩个日期的前后:" + customizedDate.isBefore(currentDate));
        System.out.println("比较俩个日期的前后:" + customizedDate.isAfter(currentDate));

        Period between = Period.between(currentDate, customizedDate);
        System.out.println("俩个日期之间相差: " + " 年数为：" + between.getYears());
        System.out.println("俩个日期之间相差: " + " 月数为：" + between.getMonths());
        System.out.println("俩个日期之间相差: " + " 天数为：" + between.getDays());

        System.out.println();

        YearMonth currentYearMonth = YearMonth.now();
        System.out.println("当前年月为：" + currentYearMonth);
        System.out.println("当前年月的天数为：" + currentYearMonth.lengthOfMonth());
        MonthDay currentMonthDay = MonthDay.now();
        System.out.println("当前月日为：" + currentMonthDay);

        LocalTime currentTime = LocalTime.now();
        System.out.println("当前时间为：" + currentTime);
        System.out.println("一小时后的时间为：" + currentTime.plus(1, ChronoUnit.HOURS));

        Instant currentTimestamp = Instant.now();
        System.out.println("当前的时间戳为：" + currentTimestamp);

        System.out.println();

        // 格式化 字符串 -> 日期 -> 字符串
        String dateString = "20190320";
        LocalDate parseDate = LocalDate.parse(dateString, DateTimeFormatter.BASIC_ISO_DATE);

        System.out.println("字符串20190320转换为的日期对象为：" + parseDate);
        String dateString2 = parseDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        String dateString3 = parseDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("日期转换为字符串为：" + dateString2);
        System.out.println("日期转换为字符串为：" + dateString3);

        // 字符串与日期互转
        System.out.println("日期转自定义格式字符串：" + DateUtil.date2String(LocalDateTime.now(), DateUtil.YYYY_MM_DD_HH_MM_SS));


        String str1 = "2018-07-05 12:24:12";
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(str1, dtf2);
        System.out.println(parse);


    }


}
