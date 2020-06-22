package com.qy.zk;

import com.sun.glass.ui.Size;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ZkLock implements Lock {

    private static final String IP_PORT = "39.105.162.159:12181,39.105.162.159:12182,39.105.162.159:12183";
    private static final String Z_NODE = "/ZKLOCK";

    private ZkClient zkClient = new ZkClient(IP_PORT);

    public ZkLock() {
        if (!zkClient.exists(Z_NODE)) {
            zkClient.createPersistent(Z_NODE);
        }
    }

    @Override
    public void lock() {
        if (!tryLock()) {
            lock();
        }
    }

    @Override
    public boolean tryLock() {
        // 第一次就进来创建自己的临时节点
        String curPath = zkClient.createEphemeralSequential(Z_NODE + "/", "lock");
        // 对节点排序
        List<String> children = zkClient.getChildren(Z_NODE);
        System.out.println("size === "+ children.size());
        Collections.sort(children);

        // 当前的是最小节点就返回加锁成功
        if (curPath.equals(Z_NODE + "/" + children.get(0))) {
            System.out.println(Thread.currentThread().getName()+":获得锁");
            return true;
        }
        // 不是最小节点 就找到自己的前一个 依次类推 释放也是一样
        int i = Collections.binarySearch(children, curPath.substring(Z_NODE.length() + 1));
        String beforePath = Z_NODE + "/" + children.get(i - 1);
        return false;
    }

    public void waitForLock() {
        IZkDataListener listener = new IZkDataListener() {
            public void handleDataChange(String s, Object o) throws Exception {
            }
            public void handleDataDeleted(String s) throws Exception {
                System.out.println(Thread.currentThread().getName() + ":监听到节点删除事件！---------------------------");
                cdl.countDown();
            }
        };
        // 监听
        this.zkClient.subscribeDataChanges(beforePath, listener);
        if (zkClient.exists(beforePath)) {
            try {
                System.out.println(Thread.currentThread().getName() + ":加锁失败,等待");
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 释放监听
        zkClient.unsubscribeDataChanges(beforePath, listener);
    }

    @Override
    public void unlock() {
        zkClient.delete(curPath);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }


    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }

}
