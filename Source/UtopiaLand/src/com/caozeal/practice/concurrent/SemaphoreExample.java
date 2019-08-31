package com.caozeal.practice.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * <p>创建时间：2018/7/31 12:34
 * <p>com.writ.practice.concurrent
 * @author caozhiyong
 * @version 1.0
 */
public class SemaphoreExample {

    public static void main(String[] args) {
        final int clientCount = 3;
        final int totalRequestCount = 10;
        Semaphore semaphore = new Semaphore(clientCount);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalRequestCount; i++) {
            executorService.execute(()->{
                try {
                    System.out.println("before:" + semaphore.availablePermits());
                    semaphore.acquire();
                    System.out.println("mid:" + semaphore.availablePermits());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                    System.out.println("after:" + semaphore.availablePermits());
                }
            });
        }
        executorService.shutdown();
    }
}
