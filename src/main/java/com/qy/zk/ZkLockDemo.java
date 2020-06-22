package com.qy.zk;

public class ZkLockDemo {

    //剩余资源数
    private static int surPlusResource = 10;
    //争抢线程数
    private static final int THREAD_COUNT = 20;

    public static void main(String[] args) {
        ZkLock zkLock = new ZkLock();
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(() -> {
                try {
//                    Thread.sleep(1000);
                    zkLock.lock();
                    if (surPlusResource > 0) {
                        surPlusResource--;
                    }
                    System.out.println(Thread.currentThread().getName()+":剩余"+surPlusResource);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    zkLock.unlock();
                    System.out.println(Thread.currentThread().getName()+":释放锁");
                }
            },i+"").start();
        }
    }
}
