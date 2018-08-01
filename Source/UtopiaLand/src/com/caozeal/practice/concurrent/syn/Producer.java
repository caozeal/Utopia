package com.caozeal.practice.concurrent.syn;

import java.util.Random;

/**
 * <p>创建时间：2018/8/1 16:18
 * <p>com.caozeal.practice.concurrent.syn
 * @author caozhiyong
 * @version 1.0
 */
public class Producer {

    public boolean product() throws InterruptedException {
            if (ProductQueue.isFull()) {
                System.out.println("产品已满,请稍候再生产");
                return false;
            }
            ProductQueue.offer(new Random().nextInt());
            return true;
        }
}
