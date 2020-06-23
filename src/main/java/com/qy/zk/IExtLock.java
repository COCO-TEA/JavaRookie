package com.qy.zk;

public interface IExtLock {

    //ExtLock基于zk实现分布式锁
    public void  getLock();

    //释放锁
    public void unLock();

}
