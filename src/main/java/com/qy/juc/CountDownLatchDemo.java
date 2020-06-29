package com.qy.juc;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch（倒计时器）：await()让一些线程阻塞直到另外一些完成后才被唤醒 (秦灭六国)
 * 1.某一线程在开始运行前等待 n 个线程执行完毕。
 * 2.实现多个线程开始执行任务的最大并行性。
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() +"\t 国被灭");
                countDownLatch.countDown();
            },String.valueOf(i)).start();

        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() +"\t 秦国统一");

    }

}
