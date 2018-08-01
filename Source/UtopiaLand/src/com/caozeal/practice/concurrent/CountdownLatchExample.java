package com.caozeal.practice.concurrent;

import java.util.concurrent.*;

/**
 * <p>创建时间：2018/7/31 11:13
 * <p>com.caozeal.practice.concurrent
 * @author caozhiyong
 * @version 1.0
 */
public class CountdownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        final int totalThread = 100;
        CountDownLatch countDownLatch = new CountDownLatch(totalThread);
        ExecutorService executorService =new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        for (int i = 0; i < totalThread; i++) {
            executorService.execute(() -> {
                System.out.print("run..");
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println("end");
        executorService.shutdown();
    }
}
