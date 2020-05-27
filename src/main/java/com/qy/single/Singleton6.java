package com.qy.single;

/**
 * 枚举
 */
public enum Singleton6 {

    INSTANCE;

    private Main main = null;

    private Singleton6() {
        main = new Main();
    }

    public Main getIntance() {
        return main;
    }
}
