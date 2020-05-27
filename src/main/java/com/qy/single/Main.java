package com.qy.single;

import java.lang.reflect.Constructor;

public class Main {

    public static void main(String[] args) {
        Main main1 = Singleton6.INSTANCE.getIntance();
        Main main2 = Singleton6.INSTANCE.getIntance();
        System.out.println(main1);
        System.out.println(main2);

        Singleton1 singleton1 = Singleton1.getInstance();

    }
}
