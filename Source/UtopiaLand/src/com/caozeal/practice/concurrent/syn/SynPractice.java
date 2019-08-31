package com.caozeal.practice.concurrent.syn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>创建时间：2018/7/30 15:14
 * <p>com.writ.practice.concurrent
 * @author caozhiyong
 * @version 1.0
 */
public class SynPractice {

    public static void test1() {
        Object lock = new Object();
//        synchronized (lock) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            for (int i = 0; i < 100; i++) {
//                try {
//                    lock.wait();           //wait(),notify()只能针对被锁的对象
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.print(i + "11 ");
//                lock.notify();
            }
//        }
    }

    public static void test2(){
        Object lock = new Object();
//        synchronized (lock) {
            for (int i = 0; i < 100; i++) {
                System.out.print(i + "22 ");
                lock.notify();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//            }
//            notify();
        }
    }

    public static void main(String[] args) {
        SynPractice e1 = new SynPractice();
        SynPractice e2 = new SynPractice();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> SynPractice.test1());
        executorService.execute(() -> SynPractice.test1());
    }
}
