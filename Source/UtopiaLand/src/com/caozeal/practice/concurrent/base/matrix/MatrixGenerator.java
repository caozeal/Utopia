package com.caozeal.practice.concurrent.base.matrix;

import java.util.Random;

public class MatrixGenerator {

    /**
     * 生成随机矩阵
     * @param rows
     * @param columns
     * @return
     */
    public static double[][] generate(int rows, int columns){
        double[][] ret = new double[rows][columns];
        Random random = new Random();
        for (double[] doubles : ret) {
            for (int i = 0; i < doubles.length; i++) {
                doubles[i] = random.nextDouble() * 10;
            }
        }
        return ret;
    }
}
