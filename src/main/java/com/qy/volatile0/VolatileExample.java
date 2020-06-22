package com.qy.volatile0;

/**
 * 读取volatile变量后，再读取非volatile变量，
 * 在volatile变量修改之前的数据，一定也会修改
 */
public class VolatileExample {

    int x = 0;
    volatile boolean v = false;

    public void writer() {
        x = 42;
        v = true;
    }

    public void reader() {
//        int y = x;
//        System.out.println(y);
//        while (v != true) {
//
//        }
        while (x != 42) {
//            System.out.println("x != 42");
//            break;
        }
    }

    public static void main(String[] args) throws Exception {
        VolatileExample volatileExample = new VolatileExample();
        new Thread(() -> {


            volatileExample.reader();

        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        volatileExample.writer();

    }
}
