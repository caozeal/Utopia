package com.caozeal.practice.concurrent.odevity;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

/**
 * <p>创建时间：2019/3/14 10:57
 * <p>com.caozeal.practice.concurrent.odevity
 * @author caozhiyong
 * @version 1.0
 */
public class EvenTask implements Runnable{

    private AtomicInteger num;
    private int max;

    public EvenTask(AtomicInteger num, int max) {
        this.num = num;
        this.max = max;
    }

    @Override
    public void run() {
        while (num.get() <= max){
            if(num.get()%2 == 0 && num.get() <= max){
                System.out.println("偶线程： " + num);
                num.getAndIncrement();
            }
        }
    }
}
