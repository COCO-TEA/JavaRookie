package com.qy.thread.pool;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {

        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        try{
            for(int i=1;i<=11;i++){
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }

    }

    private static void threadPoolInit() {
        //固定线程数为10个，无穷队列
        ExecutorService threadPool1 = Executors.newFixedThreadPool(5);
        //没有核心线程，最多 Integer.MAX_VALUE 个线程
        ExecutorService threadPool2 = Executors.newCachedThreadPool();
        //1个线程，无穷队列
        ExecutorService threadPool3 = Executors.newSingleThreadExecutor();

        try{
            for(int i=1;i<=10;i++){
                threadPool2.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            threadPool1.shutdown();
            threadPool2.shutdown();
            threadPool3.shutdown();
        }
    }
}
