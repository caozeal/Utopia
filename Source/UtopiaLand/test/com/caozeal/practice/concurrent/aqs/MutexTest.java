package com.caozeal.practice.concurrent.aqs;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class MutexTest {

    Mutex lock = new Mutex();
    ExecutorService executorService = Executors.newCachedThreadPool();

    @BeforeMethod
    public void setUp() throws Exception {

    }

    private void print(){
        lock.lock();
        try {
            System.out.println("获取到锁:" + Thread.currentThread().getName());
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println("释放了锁:" + Thread.currentThread().getName());
    }

    @Test
    public void testLock() throws Exception {
        executorService.execute(()->print());
        executorService.execute(()->print());
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void testLockInterruptibly() throws Exception {
    }

    @Test
    public void testTryLock() throws Exception {
    }

    @Test
    public void testTryLock1() throws Exception {
    }

    @Test
    public void testUnlock() throws Exception {
    }

    @Test
    public void testNewCondition() throws Exception {
    }
}