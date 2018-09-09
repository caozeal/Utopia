package com.caozeal.sometry.concurrent.collection;

import com.caozeal.sometry.concurrent.Author;
import com.caozeal.sometry.concurrent.Update;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class TimeLineTest {

    public static void main(String[] args) {
        final CountDownLatch firstLatch = new CountDownLatch(1);
        final CountDownLatch secondLatch = new CountDownLatch(1);
        final Update.Builder builder = new Update.Builder();

        final CopyOnWriteArrayList<Update> updates = new CopyOnWriteArrayList<>();
        updates.add(builder.author(new Author("Lilith")).updateText("Happy dance").builder());
        updates.add(builder.author(new Author("Sakura")).updateText("Gaming").builder());

        ReentrantLock lock = new ReentrantLock();
        final MicroBlogTimeLine line1 = new MicroBlogTimeLine(updates, lock, "TL1");
        final MicroBlogTimeLine line2 = new MicroBlogTimeLine(updates, lock, "TL2");

        Thread t1 = new Thread(){
            public void run(){
                updates.add(builder.author(new Author("Sam")).updateText("Go Work").builder());
                line1.prep();
                firstLatch.countDown();
                try {
                    secondLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                line1.printTimeLine();
            }
        };

        Thread t2 = new Thread(){
            public void run(){
                try {
                    firstLatch.await();
                    updates.add(builder.author(new Author("Jerrfy")).updateText("Have a good time").builder());
                    line2.prep();
                    secondLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                line2.printTimeLine();

            }
        };

        t1.start();
        t2.start();
    }
}
