package com.caozeal.practice.concurrent.base.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * //TODO description of this class
 *
 * @author caozhiyong
 * @version 1.0.0
 * @date 2019/3/10
 */
public class ParallelRowMultiplier {

    public static void multiply(double[][] matrix1, double[][] matrix2, double[][] result) {
        List<Thread> threads = new ArrayList<>();
        int rows1 = matrix1.length;
        for (int i = 0; i < rows1; i++) {
            RowMultiplierTask task = new RowMultiplierTask(result, matrix1, matrix2, i);
            Thread thread = new Thread(task);
            thread.start();
            threads.add(thread);
            if (threads.size() % 10 == 0) {
                waitForThreads(threads);
            }
        }
    }

    private static void waitForThreads(List<Thread> threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threads.clear();
    }
}
