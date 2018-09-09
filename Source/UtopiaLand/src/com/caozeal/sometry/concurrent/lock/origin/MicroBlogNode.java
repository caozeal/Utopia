package com.caozeal.sometry.concurrent.lock.origin;

import com.caozeal.sometry.concurrent.Update;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MicroBlogNode {

    private final Lock lock = new ReentrantLock();

    private final String ident;

    public MicroBlogNode(String ident) {
        this.ident = ident;
    }

    public void propagateUpdate(Update update, MicroBlogNode node){
        lock.lock();
        try {
            System.out.println("update = [" + update.getAuthor().getName() + "], node = [" + node.ident + "]");
            node.confirmUpdate(this, update);
        }finally {
            lock.unlock();
        }
    }

    private void confirmUpdate(MicroBlogNode node, Update update) {
        lock.lock();
        try {
            System.out.println("node = [" + node.ident + "], update = [" + update.getAuthor().getName() + "]");
        }finally {
            lock.unlock();
        }
    }
}
