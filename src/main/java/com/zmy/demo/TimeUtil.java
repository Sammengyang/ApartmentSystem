package com.zmy.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-04-28 11:07
 */
public class TimeUtil {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     *  解析日期模板 yyyy-MM-dd
     * @param dateStr :字符串类型的日期
     * @return date :解析过后的日期util.Date
     */
    public static Date parse(String dateStr){
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 格式化日期
     *
     * @param date ：需要格式化的日期
     * @return str ： 返回字符串
     */
    public static String format(Date date){
        return sdf.format(date);
    }

}
