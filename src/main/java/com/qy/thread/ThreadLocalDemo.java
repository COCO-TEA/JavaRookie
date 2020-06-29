package com.qy.thread;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * ThreadLocal 演示每个线程一份数据
 */
public class ThreadLocalDemo {

    public static void main(String[] args) throws Exception {

        ThreadLocal<String> local = new ThreadLocal<>();
        local.set("AAAAA");

        Random random = new Random();
        IntStream.range(0,5).forEach(a -> new Thread( () ->{
            local.set(a + " " + random.nextInt(100));
            System.out.println("线程和local值分别是 "+local.get());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start());

    }
}
