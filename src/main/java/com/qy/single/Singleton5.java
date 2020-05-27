package com.qy.single;

/**
 * 静态内部类
 */
public class Singleton5 {

    private Singleton5() {}

    public static final Singleton5 getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final Singleton5 INSTANCE = new Singleton5();
    }
}
