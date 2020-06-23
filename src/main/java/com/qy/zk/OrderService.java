package com.qy.zk;


public class OrderService implements Runnable {

    private NumGenerator orderNumGenerator = new NumGenerator(); // 定义成全局的
    private IExtLock lock = new ZookeeperDistrbuteLock();

    public void run() {
        getNumber();
    }

    public void getNumber() { //让一个线程操作
        try {
            lock.getLock();
            String number = orderNumGenerator.getNumber();
            System.out.println(Thread.currentThread().getName() + ",number" + number);

        } catch (Exception e) {

        } finally {
            lock.unLock();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) { // 开启100个线程
            //模拟分布式锁的场景
            new Thread(new OrderService()).start();
        }
    }

}

