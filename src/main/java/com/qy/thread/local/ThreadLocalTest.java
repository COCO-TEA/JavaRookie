package com.qy.thread.local;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 演示ThreadLocal如何在多线程下保证线程安全
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("thread %d").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20, 20, 01,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024));

        for (int i = 0; i < 20; i++) {
            threadPoolExecutor.execute(
                    () -> System.out.println(DateUtilNotSafe.parse("2019-02-02 10:10:01"))
//                    () -> System.out.println(DateUtilSafe.parse("2019-02-02 10:10:01"))
            );
        }

        threadPoolExecutor.shutdown();
    }
}
