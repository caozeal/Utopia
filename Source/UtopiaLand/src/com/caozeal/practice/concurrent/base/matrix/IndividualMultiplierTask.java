package com.caozeal.practice.concurrent.base.matrix;

/**
 * //TODO description of this class
 *
 * @author caozhiyong
 * @version 1.0.0
 * @date 2019/3/10
 */
public class IndividualMultiplierTask implements Runnable{

    private final double[][] result;
    private final double[][] m1;
    private final double[][] m2;

    private final int row;
    private final int column;

    public IndividualMultiplierTask(double[][] result, double[][] m1, double[][] m2, int row, int column) {
        this.result = result;
        this.m1 = m1;
        this.m2 = m2;
        this.row = row;
        this.column = column;
    }

    @Override
    public void run() {
        result[row][column] = 0;
        for (int i = 0; i < m1[row].length; i++) {
            result[row][column] += m1[row][i] * m2[i][column];
        }
    }
}
