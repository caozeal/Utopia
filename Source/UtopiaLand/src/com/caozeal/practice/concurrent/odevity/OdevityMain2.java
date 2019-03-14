package com.caozeal.practice.concurrent.odevity;

/**
 * <p>创建时间：2019/3/14 13:42
 * <p>com.caozeal.practice.concurrent.odevity
 * @author caozhiyong
 * @version 1.0
 */
public class OdevityMain2 {
    static class SolutionTask implements Runnable {
        static int value = 0;

        @Override
        public void run() {
            synchronized (SolutionTask.class) {
                while (value <= 100) {
                    System.out.println(Thread.currentThread().getName() + "： " + value++);
                    SolutionTask.class.notify();
                    try {
                        SolutionTask.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                SolutionTask.class.notify();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new SolutionTask(), "偶线程").start();
        new Thread(new SolutionTask(), "奇线程").start();
    }
}