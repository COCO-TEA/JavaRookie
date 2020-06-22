package com.qy.volatile0;

import com.sun.org.apache.xpath.internal.axes.WalkingIterator;

public class VolatileDemo {

    public boolean isReady = false;
    public volatile boolean isReady1 = false;

    public static void main(String[] args) throws InterruptedException {
        VolatileDemo volatileDemo = new VolatileDemo();

        Thread readyThread_finish = new Thread(() -> {
            while (!volatileDemo.isReady) {

            }
            System.out.println("ReadyThread finish");
        });

        readyThread_finish.start();

        Thread.sleep(1000);//sleep 1秒钟确保ReadyThread线程已经开始执行
        volatileDemo.isReady = true;//写操作，----1.写进主内存       //---2.所有缓存失效
        volatileDemo.isReady1 = true;


//        new Thread(() -> {
//            while (!volatileDemo.isReady) {
//
//            }
//            System.out.println("ReadyThread finish11111");
//        }).start();
    }

}
