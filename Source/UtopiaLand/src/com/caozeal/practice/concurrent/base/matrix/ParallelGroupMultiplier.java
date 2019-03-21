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
public class ParallelGroupMultiplier {

    public static void multiply(double[][] matrix1, double[][] matrix2, double[][] result) {
        List<Thread> threads = new ArrayList<>();
        int rows1 = matrix1.length;
        int numThreads = Runtime.getRuntime().availableProcessors();
        System.out.println(numThreads);
        int startIndex = 0;
        int step = rows1 / numThreads;
        int endIndex;

        for (int i = 0; i < rows1; i++) {
            endIndex = i==numThreads-1?rows1:startIndex+step;
            GroupMultiplierTask task = new GroupMultiplierTask(result, matrix1, matrix2, startIndex, endIndex);
            Thread thread = new Thread(task);
            thread.start();
            threads.add(thread);
            startIndex=endIndex;
        }
        threads.forEach(thread->{
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
