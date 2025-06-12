package lesson1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by lixin on 2020/4/2.
 */
class DataTest {
    private static final DateFormat DEFAULT_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());


    public static void main(String[] args) {
        String s = string2yyyyMMdd("2020-04-03 18:00:00+1200");
        System.out.println(s);
    }

    /**
     * 将后台返回的yyyy-MM-dd HH:mm:ss时间转换成dd/MM/yyyy HH:mm格式
     * @param time
     * @return
     */
    public static String string2yyyyMMdd(String time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = string2Date(time);
        return date2String(date, dateFormat);
    }


    /**
     * 将Date类型转为时间字符串
     * <p>格式为format</p>
     *
     * @param date   Date类型时间
     * @param format 时间格式
     * @return 时间字符串
     */
    public static String date2String(Date date, DateFormat format) {
        if (date == null){
            return "";
        }
        return format.format(date).toUpperCase();
    }

    /**
     * 将时间字符串转为Date类型
     * <p>time格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param time 时间字符串
     * @return Date类型
     */
    public static Date string2Date(String time) {
        return string2Date(time, DEFAULT_FORMAT);
    }

    /**
     * 将时间字符串转为Date类型
     * <p>time格式为format</p>
     *
     * @param time   时间字符串
     * @param format 时间格式
     * @return Date类型
     */
    public static Date string2Date(String time, DateFormat format) {
        try {
            return format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
