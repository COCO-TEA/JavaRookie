package com.qy.jvm;

import java.util.zip.CheckedOutputStream;

public class StackErrorTest {

    private static int count = 1;

    /**
     * 默认情况下：count:11420
     * 设置栈的大小：-Xss256K count:2455
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);
    }
}
