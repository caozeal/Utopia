package com.caozeal.practice.concurrent.odevity.more;

import java.util.concurrent.Semaphore;

/**
 * 使用到了信号量Semphore,同时只有一个线程在执行
 * <p>创建时间：2019/3/14 14:02
 * <p>com.writ.practice.concurrent.odevity.more
 * @author caozhiyong
 * @version 1.0
 */
public class MoreMain2 {

    private static int result = 0;
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        int n = 3;
        final Semaphore[] syncObjects = new Semaphore[n];
        for (int i = 0; i < n; i++) {
            syncObjects[i] = new Semaphore(1);
            if (i != n-1){
                syncObjects[i].acquire();
            }
        }
        for (int i = 0; i < n; i++) {
            final Semaphore lastSemphore = i == 0 ? syncObjects[n - 1] : syncObjects[i - 1];
            final Semaphore curSemphore = syncObjects[i];
            final int index = i;
            new Thread(() -> {
                try {
                    while (true) {
                        lastSemphore.acquire();
                        System.out.println("thread" + index + ": " + result++);
                        if (result > 1000){
                            System.out.println(System.currentTimeMillis() - start);
                            System.exit(0);
                        }
                        curSemphore.release();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }).start();
        }
    }
}
