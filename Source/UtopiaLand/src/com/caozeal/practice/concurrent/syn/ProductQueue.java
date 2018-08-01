package com.caozeal.practice.concurrent.syn;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * <p>创建时间：2018/8/1 16:20
 * <p>com.caozeal.practice.concurrent.syn
 * @author caozhiyong
 * @version 1.0
 */
public class ProductQueue {

    private static Queue<Integer> productQueue = new PriorityQueue<>();

    private ProductQueue(){

    }

    public static boolean offer(Integer product){
        System.out.println("生产者生产第" + (productQueue.size() + 1) + "个产品:" + product);
        return productQueue.offer(product);
    }

    public static Integer poll(){
        System.out.println("消费者取走了产品: " + productQueue.peek());
        return productQueue.poll();
    }

    public static Queue<Integer> getProductQueue() {
        return productQueue;
    }

    public static boolean isFull(){
        return productQueue.size() > 20;
    }

    public static boolean isEmpty(){
        return productQueue.peek() == null;
    }

    public static void main(String[] args) {
        ExecutorService produceService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L,
                TimeUnit.SECONDS, new SynchronousQueue<>(), new ThreadFactoryBuilder().setNameFormat("produce-thread-%d").build());
        ExecutorService consumeService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L,
                TimeUnit.SECONDS, new SynchronousQueue<>(), new ThreadFactoryBuilder().setNameFormat("consume-thread-%d").build());
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        for(int i=0; i<10; i++){
            produceService.execute(()->{
                while (true){
                    try {
                        synchronized (producer){
                            Thread.sleep(1000);
                            if(!producer.product()){
                                producer.wait();
                            }
                        }
                        synchronized (consumer){
                            consumer.notifyAll();
                        }
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            });
        }
        for(int i=0; i<5; i++){
            consumeService.execute(()->{
                while (true){
                    try {
                        synchronized (consumer){
                            if(!consumer.consume()){
                                consumer.wait();
                            }
                        }
                        synchronized (producer){
                            producer.notifyAll();
                        }
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            });
        }
    }
}
