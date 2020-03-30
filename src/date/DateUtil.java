package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 常用日期操作
 * Created by Roc on 2019/6/11
 */
public class DateUtil {
    public static final String NORMAL_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String Z_DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    /**
     * 一天的毫秒数
     */
    public static final Long ONE_DAY_MILLISECOND = 1000 * 60 * 60 * 24L;

    /**
     * 一小时毫秒数
     */
    public static final Long ONE_HOUR_MILLISECOND = 1000 * 60 * 60L;

    /**
     * 日期 → yyyy-MM-dd格式字符串
     *
     * @param paramDate 日期
     * @return
     */
    public static String formatDate(Date paramDate) {
        if (paramDate == null) {
            return null;
        }
        return DateUtil.formatDate(paramDate, DateUtil.NORMAL_DATE_FORMAT);
    }

    /**
     * 日期 → yyyy-MM-dd HH:mm:ss格式字符串
     *
     * @param paramDate 日期
     * @return
     */
    public static String formatDateTime(Date paramDate) {
        if (paramDate == null) {
            return null;
        }
        return DateUtil.formatDate(paramDate, DateUtil.DATETIME_FORMAT);
    }

    /**
     * yyyy-MM-dd格式字符串 → 日期
     *
     * @param paramString yyyy-MM-dd格式字符串
     * @return
     * @throws Exception
     */
    public static Date parseDate(String paramString)
            throws Exception {
        if ((paramString == null) || (paramString.trim().equals(""))) {
            return null;
        }
        return DateUtil.parseDate(paramString, DateUtil.NORMAL_DATE_FORMAT);
    }

    /**
     * yyyy-MM-dd HH:mm:ss格式字符串 → 日期
     *
     * @param paramString yyyy-MM-dd HH:mm:ss格式字符串
     * @return
     * @throws Exception
     */
    public static Date parseDateTime(String paramString)
            throws Exception {
        if ((paramString == null) || (paramString.trim().equals(""))) {
            return null;
        }
        return DateUtil.parseDate(paramString, DateUtil.DATETIME_FORMAT);
    }

    /**
     * 日期 → pattern格式字符串
     *
     * @param paramDate 日期
     * @param pattern   pattern格式
     * @return
     */
    public static String formatDate(Date paramDate, String pattern) {
        if (paramDate == null) {
            return null;
        }
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(pattern);
        localSimpleDateFormat.setLenient(false);
        return localSimpleDateFormat.format(paramDate);
    }

    /**
     * 日期字符串 → pattern格式日期
     *
     * @param paramString 日期字符串
     * @param pattern     pattern格式
     * @return
     * @throws Exception
     */
    public static Date parseDate(String paramString, String pattern)
            throws Exception {
        if ((paramString == null) || (paramString.trim().equals(""))) {
            return null;
        }
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(pattern);
        localSimpleDateFormat.setLenient(false);
        try {
            return localSimpleDateFormat.parse(paramString);
        } catch (ParseException localParseException) {
            throw new Exception("日期解析出错！", localParseException);
        }
    }

    /**
     * 获取两个时间之间的天数
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return
     */
    public static int getIntIntervalDays(Date startDate, Date endDate) {
        return (int) ((endDate.getTime() - startDate.getTime()) / ONE_DAY_MILLISECOND);
    }

    /**
     * 获取两个时间之间的小数天数
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return
     */
    public static double getDoubleIntervalDays(Date startDate, Date endDate) {
        return ((double) (endDate.getTime() - startDate.getTime()) / ONE_DAY_MILLISECOND);
    }

    /**
     * 获取两个时间之间的小时数
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return
     */
    public static double getDoubleIntervalHours(Date startDate, Date endDate) {
        return ((double) (endDate.getTime() - startDate.getTime()) / ONE_HOUR_MILLISECOND);
    }

    /**
     * 获取起始时间的小时差
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return
     */
    public static float getFloatIntervalHours(Date start, Date end) {
        return (float) (end.getTime() - start.getTime()) / ONE_HOUR_MILLISECOND;
    }

    /**
     * 日期加/减paramInt天
     *
     * @param paramDate 日期
     * @param paramInt  要加/减的天数
     * @return
     */
    public static Date addDays(Date paramDate, int paramInt) {
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTime(paramDate);
        int i = localCalendar.get(6);
        localCalendar.set(6, i + paramInt);
        return localCalendar.getTime();
    }

    /**
     * 日期加/减paramInt个月
     *
     * @param paramDate 日期
     * @param paramInt  加/减数
     * @return
     */
    public static Date addMonths(Date paramDate,
                                 int paramInt) {
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTime(paramDate);
        localCalendar.add(2, paramInt);
        return localCalendar.getTime();
    }

    /**
     * 日期加/减paramInt年
     *
     * @param paramDate
     * @param paramInt
     * @return
     */
    public static Date addYears(Date paramDate,
                                int paramInt) {
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTime(paramDate);
        localCalendar.add(Calendar.YEAR, paramInt);
        return localCalendar.getTime();
    }

    /**
     * 日期加/减paramInt秒
     *
     * @param paramDate 日期
     * @param paramInt  加/减数
     * @return
     */
    public static Date addSeconds(Date paramDate, int paramInt) {
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTime(paramDate);
        localCalendar.add(Calendar.SECOND, paramInt);
        return localCalendar.getTime();
    }

    /**
     * 日期加/减paramInt分钟
     *
     * @param paramDate 日期
     * @param paramInt  加/减数
     * @return
     */
    public static Date addMinutes(Date paramDate, int paramInt) {
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTime(paramDate);
        localCalendar.add(Calendar.MINUTE, paramInt);
        return localCalendar.getTime();
    }

    /**
     * 取某日期之后多少天的日期
     *
     * @param date
     * @param days
     * @return
     */
    public static Date getDateAfterDays(Date date, Integer days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    /**
     * 获取某一天零点
     *
     * @param date 日期
     * @return
     */
    public static Date getStartTimeOfDay(Date date) {
        if (Objects.isNull(date)) {
            return null;
        }
        Calendar day = Calendar.getInstance();
        day.setTime(date);
        //24小时
        day.set(Calendar.HOUR_OF_DAY, 0);
        day.set(Calendar.MINUTE, 0);
        day.set(Calendar.SECOND, 0);
        day.set(Calendar.MILLISECOND, 0);
        return day.getTime();
    }

    /**
     * 取某天末点
     *
     * @param date 日期
     * @return
     */
    public static Date getEndTimeOfDay(Date date) {
        if (Objects.isNull(date)) {
            return null;
        }
        Calendar day = Calendar.getInstance();
        day.setTime(date);
        //24小时
        day.set(Calendar.HOUR_OF_DAY, 23);
        day.set(Calendar.MINUTE, 59);
        day.set(Calendar.SECOND, 59);
        day.set(Calendar.MILLISECOND, 999);
        return day.getTime();
    }

    /**
     * 获取前一天开始时间
     *
     * @param date 日期
     * @return
     */
    public static Date getStartTimeOfBeforeDay(Date date) {
        Date beforeDate = DateUtil.addDays(date, -1);
        return DateUtil.getStartTimeOfDay(beforeDate);
    }

    /**
     * 获取前一天结束时间
     *
     * @param date 日期
     * @return
     */
    public static Date getEndTimeOfBeforeDay(Date date) {
        Date beforeDate = DateUtil.addDays(date, -1);
        return DateUtil.getEndTimeOfDay(beforeDate);
    }

    /**
     * 获取某一年的起始时间
     *
     * @param date 日期
     * @return
     */
    public static Date getStartTimeOfYear(Date date) {
        Calendar day = Calendar.getInstance();
        day.setTime(date);
        //24小时
        day.set(Calendar.YEAR, DateUtil.getYY(date));
        day.set(Calendar.MONTH, Calendar.JANUARY);
        day.set(Calendar.DAY_OF_MONTH, 1);
        day.set(Calendar.HOUR_OF_DAY, 0);
        day.set(Calendar.MINUTE, 0);
        day.set(Calendar.SECOND, 0);
        day.set(Calendar.MILLISECOND, 0);
        return day.getTime();
    }

    /**
     * 获取某一年的结束时间
     *
     * @param date
     * @return
     */
    public static Date getEndTimeOfYear(Date date) {
        Calendar day = Calendar.getInstance();
        day.setTime(date);
        //24小时
        day.set(Calendar.YEAR, DateUtil.getYY(date));
        day.set(Calendar.MONTH, Calendar.DECEMBER);
        day.set(Calendar.DAY_OF_MONTH, day.getActualMaximum(Calendar.DAY_OF_MONTH));
        day.set(Calendar.HOUR_OF_DAY, 23);
        day.set(Calendar.MINUTE, 59);
        day.set(Calendar.SECOND, 59);
        day.set(Calendar.MILLISECOND, 999);
        return day.getTime();
    }

    /**
     * 获取年开始时间
     *
     * @param year 年份
     * @return
     */
    public static Date getYearStartTime(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        //24小时
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取指定月的天数
     */
    public static int getMonthDayCount(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        //把日期设置为当月第一天
        calendar.set(Calendar.DATE, 1);
        //日期回滚一天，也就是最后一天
        calendar.roll(Calendar.DATE, -1);
        return calendar.get(Calendar.DATE);
    }

    /**
     * 获取指定日期上个月的第一天
     *
     * @param date
     * @return
     */
    public static Date getBeforeMonthFirstDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 获取三个月前的第一天
     *
     * @param date
     * @return
     */
    public static Date getBeforeThreeMonthFirstDayStartTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -3);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return DateUtil.getStartTimeOfDay(calendar.getTime());
    }

    /**
     * 获取指定日期上个月的第一天
     *
     * @param date
     * @return
     */
    public static Date getBeforeMonthFirstDayStartTime(Date date) {
        return DateUtil.getStartTimeOfDay(DateUtil.getBeforeMonthFirstDay(date));
    }

    /**
     * 获取指定日期上个月的最后一天
     *
     * @param date
     * @return
     */
    public static Date getBeforeMonthLastDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        return calendar.getTime();
    }

    /**
     * 获取指定日期当月的第一天
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
     * 获取指定日期当月的最后一天
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
     * 获取当前年份
     *
     * @param date 日期
     * @return
     */
    public static int getYY(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取年月数字
     *
     * @param paramDate 日期
     * @return
     */
    public static Integer getYM(Date paramDate) {
        if (paramDate == null) {
            return null;
        }
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTime(paramDate);
        int i = localCalendar.get(1);
        int j = localCalendar.get(2) + 1;
        return new Integer(i * 100 + j);
    }

    /**
     * 获取当前月份
     *
     * @param date 日期
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
     * @param date 日期
     * @return
     */
    public static int getDD(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DATE);
    }

    /**
     * 获取月份时间差
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return
     */
    public static int getIntervalMonth(Date startDate, Date endDate) {
        return ((DateUtil.getYY(endDate) - DateUtil.getYY(startDate)) * 12 + DateUtil.getMM(endDate) - DateUtil.getMM(startDate));
    }

    /**
     * 获取指定时间所在月的开始时间
     *
     * @param date
     * @return
     */
    public static Date getMonthStartDate(Date date) {
        return DateUtil.getStartTimeOfDay(DateUtil.getCurrentMonthFirstDay(date));
    }

    /**
     * 获取指定时间所在月的结束时间
     *
     * @param date
     * @return
     */
    public static Date getMonthEndDate(Date date) {
        return DateUtil.getEndTimeOfDay(DateUtil.getCurrentMonthLastDay(date));
    }

    /**
     * 获取一年前的今天
     *
     * @param date
     * @return
     */
    public static Date getOneYearAgo(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, -1);
        return calendar.getTime();
    }

    /**
     * 获取一年之后的今天
     *
     * @param date
     * @return
     */
    public static Date getOneYearAfter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, 1);
        return calendar.getTime();
    }

    /**
     * 获取 yyyy季度 字符串
     *
     * @param date 日期
     * @return
     * @throws Exception
     */
    public static String getYearQuarterByDate(Date date) {
        return DateUtil.getYY(date) + "0" + DateUtil.getQuarterByDate(date);
    }

    /**
     * 获取当前时间处在哪个季度
     *
     * @param date
     * @return
     * @throws Exception
     */
    public static int getQuarterByDate(Date date) {
        return (DateUtil.getMM(date) + 2) / 3;
    }

    /**
     * 获取季度开始月份
     *
     * @param quarter 季度
     * @return
     */
    public static int getQuarterStartMonth(int quarter) {
        return (quarter * 3 - 2);
    }

    /**
     * 获取季度结束月份
     *
     * @param quarter 季度
     * @return
     */
    public static int getQuarterEndMonth(int quarter) {
        return (quarter * 3);
    }

    /**
     * 获取指定时间所在月的第一天
     *
     * @param date 日期
     * @return 数字
     */
    public static int getMonthFirstDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取指定时间所在月的最后一天
     *
     * @param date 日期
     * @return 数字
     */
    public static int getMonthLastDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取两个时间之间的list，排除结束时间
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @return
     */
    public static List<Date> getDateListExcludeEnd(Date begin, Date end) {
        List<Date> dateList = new ArrayList<>();
        Calendar beginDate = Calendar.getInstance();
        beginDate.setTime(DateUtil.getStartTimeOfDay(begin));
        Long time = beginDate.getTimeInMillis();
        Calendar endDate = Calendar.getInstance();
        endDate.setTime(DateUtil.getStartTimeOfDay(end));
        while (time < endDate.getTimeInMillis()) {
            Date d = new Date(time);
            dateList.add(d);
            time += ONE_DAY_MILLISECOND;
        }
        return dateList;
    }

    /**
     * 获取两个时间之间的list
     *
     * @param begin
     * @param end
     * @return
     */
    public static List<Date> getDateList(Date begin, Date end) {
        List<Date> dateList = new ArrayList<>();
        Calendar beginDate = Calendar.getInstance();
        beginDate.setTime(DateUtil.getStartTimeOfDay(begin));
        Long time = beginDate.getTimeInMillis();
        Calendar endDate = Calendar.getInstance();
        endDate.setTime(DateUtil.getStartTimeOfDay(end));
        while (time <= endDate.getTimeInMillis()) {
            Date d = new Date(time);
            dateList.add(d);
            time += ONE_DAY_MILLISECOND;
        }
        return dateList;
    }

    /**
     * 获取两个时间之间的字符串形式日期
     *
     * @param begin
     * @param end
     * @return
     */
    public static List<String> getDateStrList(Date begin, Date end) {
        List<String> dateStrList = new ArrayList<>();
        Calendar beginDate = Calendar.getInstance();
        beginDate.setTime(DateUtil.getStartTimeOfDay(begin));
        Long time = beginDate.getTimeInMillis();
        Calendar endDate = Calendar.getInstance();
        endDate.setTime(DateUtil.getStartTimeOfDay(end));
        while (time <= endDate.getTimeInMillis()) {
            Date d = new Date(time);
            dateStrList.add(DateUtil.formatDateTime(d));
            time += ONE_DAY_MILLISECOND;
        }
        return dateStrList;
    }

    /**
     * 判断下午或者上午
     *
     * @param date 日期
     * @return 返回1：下午，0：上午
     */
    public static int getAmOrPm(Date date) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(DateUtil.getEndTimeOfDay(new Date()));
        return calendar.get(GregorianCalendar.AM_PM);
    }

    /**
     * 判断是否是一个月的第一天
     *
     * @param date 日期
     * @return
     */
    public static boolean isMonthFirstDay(Date date) {
        long startDate = DateUtil.getMonthStartDate(date).getTime();
        long startTimeOfDay = DateUtil.getStartTimeOfDay(date).getTime();
        return startDate == startTimeOfDay;
    }

    /**
     * 获取传入时间所在周的一周时间列表
     *
     * @param date
     * @return
     */
    public static List<Date> getWeekList(Date date) {
        Date startTimeOfDay = DateUtil.getStartTimeOfDay(date);
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(startTimeOfDay);
        //设置周一为起始时间
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        //周一
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        Date startDate = calendar.getTime();
        //周日
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        Date endDate = calendar.getTime();
        return DateUtil.getDateList(startDate, endDate);
    }

    /**
     * 获取当前时间所在周的周一
     *
     * @param date
     * @return
     */
    public static Date getWeekStartDate(Date date) {
        Date startTimeOfDay = DateUtil.getStartTimeOfDay(date);
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(startTimeOfDay);
        //设置周一为起始时间
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        //周一
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return calendar.getTime();
    }

    /**
     * 获取当前时间所在周的周末
     *
     * @param date 日期
     * @return
     */
    public static Date getWeekEndDate(Date date) {
        Date startTimeOfDay = DateUtil.getStartTimeOfDay(date);
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(startTimeOfDay);
        //设置周一为起始时间
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        //周日
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return calendar.getTime();
    }

    /**
     * 获取昨天开始时间
     *
     * @param date 日期
     * @return
     */
    public static Date getYesterdayStartTime(Date date) {
        Date startTimeOfDay = DateUtil.getStartTimeOfDay(date);
        return DateUtil.addDays(startTimeOfDay, -1);
    }

    /**
     * @param amount 正数：当前时间之后的月；负数：当前月之后的月份
     * @return
     */
    public static List<Date> getDateList(Date date, int amount) {
        Calendar begin = null;
        Calendar end = null;
        List<Date> dateList = new ArrayList<>();
        Long oneDay = 1000 * 60 * 60 * 24L;
        if (amount > 0) {
            //往后统计数据
            begin = Calendar.getInstance();
            begin.setTime(date);
            //开始时间减一天
            begin.add(Calendar.DATE, -1);
            end = Calendar.getInstance();
            end.setTime(date);
            //月份加一个月
            end.add(Calendar.MONTH, amount);
        } else {
            //往前统计数据
            begin = Calendar.getInstance();
            begin.setTime(date);
            // 月份减相应月份
            begin.add(Calendar.MONTH, amount);
            end = Calendar.getInstance();
            end.setTime(date);
            //时间加一天
            end.add(Calendar.DATE, 1);
        }
        Long time = begin.getTimeInMillis();
        while (time <= end.getTimeInMillis()) {
            Date d = new Date(time);
            dateList.add(d);
            time += oneDay;
        }
        return dateList;
    }

    /**
     * 判断日期是不是周末
     *
     * @param date 日期
     * @return
     */
    public static boolean isWeekend(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        boolean isSaturday = calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY;
        boolean isSunday = calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
        return isSaturday || isSunday;
    }
}
