package com.caozeal.practice.concurrent.syn;

/**
 * <p>创建时间：2018/8/1 16:18
 * <p>com.caozeal.practice.concurrent.syn
 * @author caozhiyong
 * @version 1.0
 */
public class Consumer {

    public boolean consume() throws InterruptedException {
        if (ProductQueue.isEmpty()) {
            System.out.println("缺货,稍候再取");
            return false;
        }
        ProductQueue.poll();
       return true;
    }
}
