package com.caozeal.practice.concurrent.odevity;

import org.apache.commons.lang.math.NumberUtils;

import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

/**
 * <p>创建时间：2019/3/14 10:53
 * <p>com.writ.practice.concurrent.odevity
 * @author caozhiyong
 * @version 1.0
 */
public class OddTask implements Runnable {

    private AtomicInteger num;
    private int max;

    public OddTask(AtomicInteger num, int max) {
        this.num = num;
        this.max = max;
    }

    @Override
    public void run() {
        while (num.get() <= max){
            if(num.get()%2 == 1 && num.get() <= max){
                System.out.println("奇线程： " + num.get());
                num.getAndIncrement();
            }
        }
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        DecimalFormat df = new DecimalFormat("#.##%");
        String p = df.format((a * 1f) / b);
        System.out.println(p);
    }
}
