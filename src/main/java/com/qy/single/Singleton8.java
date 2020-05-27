package com.qy.single;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 使用CAS机制实现单例模式
 */
public class Singleton8 {

    private static final AtomicReference<Singleton8> INSTANCE = new AtomicReference<Singleton8>();

    private Singleton8() {}

    public static Singleton8 getInstance() {
        for(;;) {
            Singleton8 singleton8 = INSTANCE.get();
            if (null != singleton8) {
                return singleton8;
            }
            singleton8 = new Singleton8();//如果有N个线程同时创建，会有大量对象被创建，可能导致内存溢出。
            if (INSTANCE.compareAndSet(null,singleton8)) {//如果忙等待一直执行不成功(一直在死循环中)，会对CPU造成较大的执行开销。
                return singleton8;
            }
        }
    }
}
