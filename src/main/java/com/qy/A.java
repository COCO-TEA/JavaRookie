package com.qy;

public class A {

    public static void main(String[] args) {
        int a = (2 << 24) -1;
        System.out.println(a);
        String x = Integer.toHexString(a);
        System.out.println(x);
    }
}
