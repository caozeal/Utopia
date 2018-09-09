package com.caozeal.sometry.concurrent.lock.second;

import com.caozeal.sometry.concurrent.Author;
import com.caozeal.sometry.concurrent.Update;

public class DeadLockTest {

    public static void main(String[] args) {
        final MicroBlogNode local = new MicroBlogNode("localhost:8888");
        final MicroBlogNode other = new MicroBlogNode("localhost:8988");

        Update.Builder builder = new Update.Builder();
        final Update first = builder.author(new Author("Alice")).updateText("Sun").builder();
        final Update second = builder.author(new Author("Hank")).updateText("Moon").builder();

        new Thread(new Runnable() {
            @Override
            public void run() {
                local.propagateUpdate(first, other);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                other.propagateUpdate(second, local);
            }
        }).start();
    }
}
