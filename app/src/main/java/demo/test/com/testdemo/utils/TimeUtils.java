package demo.test.com.testdemo.utils;

import android.text.TextUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


public class TimeUtils {

    /**
     * Long类型的时间转换成：n秒前/n分钟前/n小时前/日期
     *
     * @param time   long类型的时间
     * @param format 很长时间前显示的日期格式
     * @return Time
     */
    public static String dataLongToSNS(long time, String format) {
        long now = System.currentTimeMillis();
        long diff = now - time;
        diff = diff / 1000; // 秒

        if (diff < 0) {
            return dateLongToString(time, format);
        }

        if (diff < 30) { // 30秒
            return "刚刚";
        }

        if (diff < 60) {
            return String.format("%s秒前", diff);
        }

        if (diff < 3600) {
            return String.format("%s分钟前", diff / 60);
        }
        //获取今天凌晨时间
        long todayStart = getMorning(new Date()).getTime();

        if (time >= todayStart) { // 今天
            return String.format("%s小时前", diff / 3600);
        }

        if (time < todayStart && time >= todayStart - 86400000) {
//            return "昨天 " + longTurnTime(time, "yyyy-MM-dd HH:mm:ss", "GMT+8");
            return "昨天";
        }
        return dateLongToString(time, "yyyy-MM-dd");
    }

    //获取今天凌晨的时间
    private static Date getMorning(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static String dateLongToString(long time) {
        return dateLongToString(time, null);
    }

    private static String dateLongToString(long time, String format) {
        if (time <= 0) {
            return "Empty";
        }
        DateFormat format2 = new SimpleDateFormat(format, Locale.CHINA);
        format2.setTimeZone(TimeZone.getTimeZone("GMT+8"));

        return format2.format(new Date(time));//此处一定要记得*1000 否则显示1970年的时间
    }

    /**
     * 字符串时间转long
     *
     * @param strTime 时间
     * @return LongTime
     */
    public static long timeTurnLong(String strTime) {
        return timeTurnLong(strTime, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 字符串时间转long
     *
     * @param strTime 时间
     * @param format  时间格式
     * @return LongTime
     */
    public static long timeTurnLong(String strTime, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        long time = 0;
        try {
            Date date = sdf.parse(strTime);
            time = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;

    }


    /**
     * long类型时间转字符串
     *
     * @param longTime long时间
     * @return StrTime
     */
    public static String longTurnTime(long longTime) {
        String timeZone = "GMT+8";
        String format = "yyyy-MM-dd HH:mm:ss";
        return longTurnTime(longTime, format, timeZone);
    }

    /**
     * long类型时间转字符串
     *
     * @param longTime long时间
     * @param format   时间格式
     * @return StrTime
     */
    public static String longTurnTime(long longTime, String format) {

        String timeZone = "GMT+8";
        return longTurnTime(longTime, format, timeZone);
    }

    /**
     * long类型时间转字符串
     *
     * @param longTime long时间
     * @param format   时间格式
     * @param timeZone 时区
     * @return StrTime
     */
    public static String longTurnTime(long longTime, String format, String timeZone) {
        if (TextUtils.isEmpty(timeZone)) {
            timeZone = "GMT+8";
        }
        SimpleDateFormat sf = new SimpleDateFormat(format, Locale.CHINA);
        sf.setTimeZone(TimeZone.getTimeZone(timeZone));
        Date date = new Date(longTime);
        return sf.format(date);
    }

    /**
     * 比较两个字符串类型的时间的大小
     *
     * @param timeStr1 第一个时间
     * @param timeStr2 第二个时间
     * @return 第一个时间在第二个时间之后，return true
     */
    public static boolean timeAfterTime(String timeStr1, String timeStr2) {
        String format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sf = new SimpleDateFormat(format, Locale.CHINA);
        try {
            Date time1 = sf.parse(timeStr1);
            Date time2 = sf.parse(timeStr2);
            return time1.after(time2);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }



}


