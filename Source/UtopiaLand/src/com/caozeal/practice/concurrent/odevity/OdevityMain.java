package com.caozeal.practice.concurrent.odevity;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>创建时间：2019/3/14 10:59
 * <p>com.writ.practice.concurrent.odevity
 * @author caozhiyong
 * @version 1.0
 */
public class OdevityMain {

    public static void main(String[] args) {
        AtomicInteger min = new AtomicInteger(0);
        int max = 100;
        EvenTask evenTask = new EvenTask(min, max);
        OddTask oddTask = new OddTask(min, max);
        new Thread(evenTask).start();
        new Thread(oddTask).start();
    }
}
