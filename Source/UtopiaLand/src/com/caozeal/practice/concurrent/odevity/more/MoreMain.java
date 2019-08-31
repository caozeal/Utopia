package com.caozeal.practice.concurrent.odevity.more;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>创建时间：2019/3/14 13:56
 * <p>com.writ.practice.concurrent.odevity.more
 * @author caozhiyong
 * @version 1.0
 */
public class MoreMain {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        AtomicInteger min = new AtomicInteger(0);
        int max = 1000;
        int step = 3;
        for (int i = 0; i < step; i++) {
            new Thread(new SolutionTask(min, step, max, i, start)).start();
        }
    }
}
