package com.qy.thread;

import java.util.concurrent.TimeUnit;

public class ThreadJoinDemo {

    public static void main(String[] args) throws InterruptedException {
        threadJoin();
    }

    /**
     * 解释Thread.join() 方法，等待threadA和threadB都执行完才继续。
     * @throws InterruptedException
     */
    private static void threadJoin() throws InterruptedException {
        Thread threadA = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run finish A");
        },"A");

        Thread threadB = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run finish B");
        }, "B");
        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        System.out.println("main finish");
    }

}
