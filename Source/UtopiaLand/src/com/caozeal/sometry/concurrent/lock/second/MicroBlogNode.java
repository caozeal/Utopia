package com.caozeal.sometry.concurrent.lock.second;

import com.caozeal.sometry.concurrent.Update;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MicroBlogNode {

    private final Lock lock = new ReentrantLock();

    private final String ident;

    private long startTime;

    public MicroBlogNode(String ident) {
        this.ident = ident;
    }

    public void propagateUpdate(Update update, MicroBlogNode node){
        startTime = System.currentTimeMillis();
        boolean acquired = false;
        boolean done = false;
        while (!done){
            int wait = (int)(Math.random() * 10);
            try {
                acquired = lock.tryLock(wait, TimeUnit.MILLISECONDS);
                if(acquired){
                    System.out.println("from node = [" + ident + "], to node = [" + node.getIdent() +
                            "], update = [" + update.getAuthor().getName() + "]");
                    done = node.tryConfirmUpdate(this, update);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if(acquired){
                    lock.unlock();
                }
            }

            if(!done){
                try {
                    Thread.sleep(wait);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean tryConfirmUpdate(MicroBlogNode node, Update update) {
        boolean acquired = false;
        try {
            int wait = (int)(Math.random() * 10);
            acquired = lock.tryLock(wait, TimeUnit.MILLISECONDS);
            if(acquired){
                long elapsed = System.currentTimeMillis() - startTime;
                System.out.println("from node = [" + ident + "], to node = [" + node.getIdent() +
                        "], update = [" + update.getAuthor().getName() + "], took" + elapsed + "ms");
                return true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(acquired){
                lock.unlock();
            }
        }
        return false;
    }

    public String getIdent() {
        return ident;
    }
}
