package com.qy.juc;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 */
public class SpinLockDemo {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    /**
     * 自旋加锁
     */
    public void myLock() {
        Thread thread = Thread.currentThread();
        while (!atomicReference.compareAndSet(null,thread)) {

        }
    }

    /**
     * 自旋解锁
     */
    public void myUnLock() {
        Thread thread = Thread.currentThread();
        while (!atomicReference.compareAndSet(thread, null)) {

        }
    }

}
