package boss_android.transparent_factory.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author YangCihang
 * @since 17/9/1.
 * email yangcihang@hrsoft.net
 */

public class TimeUtil {

    /** dataFormat */
    private static SimpleDateFormat sf = null;
    /** 默认日期时间的格式 */
    public static final String DATETIME_DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /** 默认日期格式 */
    public static final String DATE_DEFAULT_FORMAT = "yyyy-MM-dd";
    /** 默认时间格式 */
    public static final String TIME_DEFAULT_FORMAT = "HH:mm:ss";
    public static final String TIME_DEFAULT_MONTH = "yyyy-MM-dd";

    /**
     * 获取系统当前时间
     */
    public static String getCurrentDate(String timeFormat) {
        Date d = new Date();
        sf = new SimpleDateFormat(timeFormat);
        return sf.format(d);
    }

    /**
     * 时间戳转换成字符串
     */
    public static String setStampToString(long time, String timeFormat) {
        Date d = new Date(time);
        sf = new SimpleDateFormat(timeFormat);
        return sf.format(d);
    }


    /**
     * 将字符串转换为时间戳(毫秒级)
     */
    public static long setStringToStamp(String time) {
        sf = new SimpleDateFormat(DATETIME_DEFAULT_FORMAT);
        Date date = new Date();
        try {
            date = sf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    /**
     * 将字符串转换为时间戳(毫秒级)
     */
    public static long setStringToStamp(String time, String format) {
        sf = new SimpleDateFormat(format);
        Date date = new Date();
        try {
            date = sf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    /**
     * 获取系统当前时间戳
     */
    public static long getCurrentTimeStamp() {
        long currentTimeStamp = System.currentTimeMillis();
        return currentTimeStamp;
    }

    /**
     * 获取当前的年
     *
     * @return 当前年数
     */
    public static int getNowYear() {
        Calendar d = Calendar.getInstance();
        return d.get(Calendar.YEAR);
    }

    /**
     * 获取当前的月数
     *
     * @return 当前月数
     */
    public static int getNowMonth() {
        Calendar d = Calendar.getInstance();
        return d.get(Calendar.MONTH);
    }


}
