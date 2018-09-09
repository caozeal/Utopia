package com.caozeal.sometry.concurrent.collection;

import com.caozeal.sometry.concurrent.Update;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class MicroBlogTimeLine {

    private final CopyOnWriteArrayList<Update> updates;

    private final ReentrantLock lock;

    private final String name;

    private Iterator<Update> iterator;

    public MicroBlogTimeLine(CopyOnWriteArrayList<Update> updates, ReentrantLock lock, String name) {
        this.updates = updates;
        this.lock = lock;
        this.name = name;
    }

    public void addUpdate(Update update){
        updates.add(update);
    }

    public void prep(){
        iterator = updates.iterator();
    }

    public void printTimeLine(){
        lock.lock();
        try {
            if(iterator != null){
                System.out.println(name + ":");
                while (iterator.hasNext()){
                    Update s = iterator.next();
                    System.out.println(s + ",");
                    Thread.sleep(100);
                }
                System.out.println();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
