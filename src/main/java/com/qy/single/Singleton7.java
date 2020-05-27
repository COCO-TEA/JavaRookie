package com.qy.single;

/**
 * 双重检锁模式
 */
public class Singleton7 {
    private static volatile Singleton7 instance;

    private Singleton7() {}

    public static Singleton7 getInstance() {
        if (instance == null) {
            synchronized (Singleton7.class) {
                instance = new Singleton7();
            }
        }
        return instance;
    }
}
