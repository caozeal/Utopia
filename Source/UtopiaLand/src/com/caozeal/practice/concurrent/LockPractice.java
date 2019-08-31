package com.caozeal.practice.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>创建时间：2018/7/30 17:11
 * <p>com.writ.practice.concurrent
 * @author caozhiyong
 * @version 1.0
 */
public class LockPractice {

    private Lock lock = new ReentrantLock();

    public void test1(){
        lock.lock();
        try {
            for (int i = 0; i < 100; i++) {
                System.out.print(i + "11 ");
            }
        }finally {
            lock.unlock();
        }
    }

    public void test2(){
        lock.lock();
        try {
            for (int i = 0; i < 100; i++) {
                System.out.print(i + "22 ");
            }
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockPractice e1 = new LockPractice();
        LockPractice e2 = new LockPractice();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> e1.test1());
        executorService.execute(() -> e1.test2());
    }
}
