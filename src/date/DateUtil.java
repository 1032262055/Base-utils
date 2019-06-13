package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 常用日期操作
 * Created by Roc on 2019/6/11
 */
public class DateUtil {

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 时间转字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static String formatDate(Date date, String format) {
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(format);
        localSimpleDateFormat.setLenient(false);
        return localSimpleDateFormat.format(date);
    }

    /**
     * 时间转yyyy-MM-dd格式字符串
     *
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        return formatDate(date, DateUtil.DATE_FORMAT);
    }

    /**
     * 时间转yyyy-MM-dd HH:mm:ss格式字符串
     *
     * @param date
     * @return
     */
    public static String formatDateTime(Date date) {
        return formatDate(date, DateUtil.DATETIME_FORMAT);
    }

    /**
     * 时间字符串转时间
     *
     * @param dateString
     * @param format
     * @return
     * @throws Exception
     */
    public static Date parseDate(String dateString, String format) throws Exception {
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(format);
        localSimpleDateFormat.setLenient(false);
        return localSimpleDateFormat.parse(dateString);
    }

    /**
     * yyyy-MM-dd格式字符串转时间
     *
     * @param dateString
     * @return
     * @throws Exception
     */
    public static Date parseDate(String dateString) throws Exception {
        return parseDate(dateString, DateUtil.DATE_FORMAT);
    }

    /**
     * yyyy-MM-dd HH:mm:ss格式字符串转时间
     *
     * @param dateString
     * @return
     * @throws Exception
     */
    public static Date parseDateTime(String dateString) throws Exception {
        return parseDate(dateString, DateUtil.DATETIME_FORMAT);
    }

    /**
     * 时间戳转时间
     *
     * @param time
     * @param format
     * @return
     * @throws ParseException
     */
    public static Date parseStamp(Long time, String format) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.parse(simpleDateFormat.format(time));
    }

    /**
     * 时间戳转yyyy-MM-dd格式时间
     *
     * @param time
     * @return
     * @throws ParseException
     */
    public static Date parseDateStamp(Long time) throws ParseException {
        return parseStamp(time, DateUtil.DATE_FORMAT);
    }

    /**
     * 时间戳转yyyy-MM-dd HH:mm:ss格式时间
     *
     * @param time
     * @return
     * @throws ParseException
     */
    public static Date parseDateTimeStamp(Long time) throws ParseException {
        return parseStamp(time, DateUtil.DATETIME_FORMAT);
    }

    /**
     * 时间转时间戳
     *
     * @param date
     * @return
     */
    public static Long dateToDateTimeStamp(Date date) {
        return date.getTime();
    }

    /**
     * 时间戳转时间字符串
     *
     * @param stamp
     * @param format
     * @return
     */
    public static String formatStamp(Long stamp, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(new Date(stamp));
    }

    /**
     * 时间戳转yyyy-MM-dd格式字符串
     *
     * @param stamp
     * @return
     */
    public static String stampToDateString(Long stamp) {
        return formatStamp(stamp, DateUtil.DATE_FORMAT);
    }

    /**
     * 时间戳转yyyy-MM-dd HH:mm:ss格式字符串
     *
     * @param stamp
     * @return
     */
    public static String stampToDateTimeString(Long stamp) {
        return formatStamp(stamp, DateUtil.DATETIME_FORMAT);
    }

    /**
     * 时间戳转时间
     *
     * @param time
     * @return
     * @throws ParseException
     */
    public static Date parseStamp(Long time) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(DateUtil.DATETIME_FORMAT);
        return format.parse(format.format(time));
    }


    /**
     * 获取某天零点
     *
     * @param date
     * @return
     */
    public static Date getStartTimeOfDay(Date date) {
        Calendar day = Calendar.getInstance();
        day.setTime(date);
        day.set(Calendar.HOUR_OF_DAY, 0);
        day.set(Calendar.MINUTE, 0);
        day.set(Calendar.SECOND, 0);
        day.set(Calendar.MILLISECOND, 0);
        return day.getTime();
    }

    /**
     * 取某天末点
     *
     * @param date
     * @return
     */
    public static Date getEndTimeOfDay(Date date) {
        Calendar day = Calendar.getInstance();
        day.setTime(date);
        day.set(Calendar.HOUR_OF_DAY, 23);
        day.set(Calendar.MINUTE, 59);
        day.set(Calendar.SECOND, 59);
        day.set(Calendar.MILLISECOND, 999);
        return day.getTime();
    }

    /**
     * 获取当前年份
     *
     * @param date
     * @return
     */
    public static int getYY(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取当前月份
     *
     * @param date
     * @return
     */
    public static int getMM(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取当前日
     *
     * @param date
     * @return
     */
    public static int getDD(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DATE);
    }

    /**
     * 获取指定日期所在月的第一天
     *
     * @param date
     * @return
     */
    public static Date getCurrentMonthFirstDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 获取指定日期所在月的最后一天
     *
     * @param date
     * @return
     */
    public static Date getCurrentMonthLastDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    /**
     * 获取起始时间的小时差
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return
     */
    public static float getIntervalHours(Date start, Date end) {
        return (float) (end.getTime() - start.getTime()) / (1000 * 60 * 60);
    }
}
