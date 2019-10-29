package com.caozeal.practice.concurrent;
import	java.io.File;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * <p>创建时间：2019/10/16 20:01
 * <p>com.caozeal.practice.concurrent
 *
 * @author caozhiyong
 * @version 1.0
 */
public class ForkJoinExample {

    public static void main(String[] args) {
        ForkJoinPool fjp = new ForkJoinPool();
        Fibonacci fib = new Fibonacci(40);
        Integer result = fjp.invoke(fib);
        System.out.println(result);
    }

    static class Fibonacci extends RecursiveTask<Integer> {

        final int n;

        public Fibonacci(int n) {
            this.n = n;
        }

        @Override protected Integer compute() {
            if(n <= 1){
                return n;
            }
            Fibonacci fib = new Fibonacci(n -1);
            fib.fork();
            Fibonacci fib1 = new Fibonacci(n - 2);
            return fib1.compute() + fib.join();
        }
    }
}
