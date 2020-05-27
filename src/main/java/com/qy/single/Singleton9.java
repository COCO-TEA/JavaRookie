package com.qy.single;

public class Singleton9 {

    private static final ThreadLocal<Singleton9> singleton9 = new ThreadLocal<Singleton9>() {

        protected Singleton9 initialValue() {
            return new Singleton9();
        }
    };

    public static Singleton9 getInstance() {
        return singleton9.get();
    }

    private Singleton9() {}
}
