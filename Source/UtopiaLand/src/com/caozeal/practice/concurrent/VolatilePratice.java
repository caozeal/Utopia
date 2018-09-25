package com.caozeal.practice.concurrent;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class VolatilePratice {

    public volatile int atomic;

    public void setAtomic(int atomic) {
        this.atomic = atomic;
    }

    public int getAtomic(){
        return atomic;
    }

    /**
     * 内存屏障在1.new Runnable的情况下生效；2.线程池核心线程数量足够的情况下生效；3.线程池核心线程不够的情况下由于其他的原因打乱了线程执行的顺序
     * 因此，内存屏障是确实存在的，volatile写前SS,写后SL，读后LL、LS
     * @param args
     */
    public static void main(String[] args) {
        VolatilePratice pratice = new VolatilePratice();
        ExecutorService executorService = new ThreadPoolExecutor(1000, 1000, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), new ThreadFactoryBuilder().setNameFormat("test-pool-%d").build());
//        for (int i=0; i<1000; i++){
//            final int a = i;
//            Runnable r = new Runnable() {
//                @Override
//                public void run() {
//                    pratice.setAtomic(a);
////                    System.out.println(pratice.getAtomic());
//                }
//            };
//            r.run();
//        }
        for (int i=0; i<1000; i++){
            final int a = i;
            Object b = new Object();
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    pratice.setAtomic(a);
//                    int num = pratice.getAtomic();
//                    System.out.println(pratice.getAtomic());
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            });
        }
        executorService.shutdown();
        System.out.println(pratice.getAtomic());
    }
}
