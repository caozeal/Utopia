package com.caozeal.practice.concurrent.odevity.more;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>创建时间：2019/3/14 13:53
 * <p>com.writ.practice.concurrent.odevity.more
 * @author caozhiyong
 * @version 1.0
 */
public class SolutionTask implements Runnable {


    private AtomicInteger num;
    private int step;
    private int max;
    private int order;
    private long start;

    public SolutionTask(AtomicInteger num, int step, int max, int order, long start) {
        this.num = num;
        this.step = step;
        this.max = max;
        this.order = order;
        this.start = start;
    }

    @Override
    public void run() {
        String threadName = "thread" + order + ": ";
        while (true){
            if(num.get() > max){
                System.out.println(System.currentTimeMillis() - start);
                System.exit(0);
            }
            if(num.get()%step == order){
                System.out.println(threadName + num);
                num.getAndIncrement();
            }
        }
    }
}
