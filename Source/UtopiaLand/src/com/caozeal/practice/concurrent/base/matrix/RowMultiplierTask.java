package com.caozeal.practice.concurrent.base.matrix;

/**
 * //TODO description of this class
 *
 * @author caozhiyong
 * @version 1.0.0
 * @date 2019/3/10
 */
public class RowMultiplierTask implements Runnable{

    private final double[][] result;
    private final double[][] m1;
    private final double[][] m2;

    private final int row;

    public RowMultiplierTask(double[][] result, double[][] m1, double[][] m2, int row) {
        this.result = result;
        this.m1 = m1;
        this.m2 = m2;
        this.row = row;
    }

    @Override
    public void run() {
        for (int i = 0; i < m2[0].length; i++) {
            result[row][i] = 0;
            for (int j = 0; j < m1[row].length; j++) {
                result[row][i] += m1[row][j] * m2[j][i];
            }
        }
    }
}
