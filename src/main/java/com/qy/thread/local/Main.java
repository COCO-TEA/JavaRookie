package com.qy.thread.local;

public class Main {

    public static void main(String[] args) {
        ThreadLocal<String> local1 = new ThreadLocal<>();
        ThreadLocal<String> local2 = new ThreadLocal<>();

        local1.set("15");
        local2.set("15");

        process();

    }

    public static void process() {

    }

}
