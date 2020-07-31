package com.qy.thread.local;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Supplier;

/**
 * 线程安全
 */
public class DateUtilSafe {

    private static final ThreadLocal<DateFormat> THREAD_LOCK = ThreadLocal.withInitial(
            () -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    );

//    private static final ThreadLocal<DateFormat> THREAD_LOCK = ThreadLocal.withInitial(
//            new Supplier<DateFormat>() {
//                @Override
//                public DateFormat get() {
//                    return new SimpleDateFormat();
//                }
//            }
//    );

    public static Date parse(String dateStr) {
        Date date = null;
        try {
            Thread.sleep(3000);
            DateFormat dateFormat = THREAD_LOCK.get();
            int i = System.identityHashCode(dateFormat);
            System.out.println(i);
            date = dateFormat.parse(dateStr);
            THREAD_LOCK.remove();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return date;
    }

}
