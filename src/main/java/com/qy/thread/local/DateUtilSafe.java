package com.qy.thread.local;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 线程安全
 */
public class DateUtilSafe {

    private static final ThreadLocal<DateFormat> THREAD_LOCK = ThreadLocal.withInitial(
            () -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    );

    public static Date parse(String dateStr) {
        Date date = null;

        try {
            date = THREAD_LOCK.get().parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

}
