package com.caozeal.practice.concurrent.base.matrix;

/**
 * //TODO description of this class
 *
 * @author caozhiyong
 * @version 1.0.0
 * @date 2019/3/10
 */
public class GroupMultiplierTask implements Runnable{

    private final double[][] result;
    private final double[][] m1;
    private final double[][] m2;

    private final int start;
    private final int end;

    public GroupMultiplierTask(double[][] result, double[][] m1, double[][] m2, int start, int end) {
        this.result = result;
        this.m1 = m1;
        this.m2 = m2;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = 0; i < start; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                result[i][j] = 0;
                for (int k = 0; k < m1[i].length; k++) {
                    result[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
    }
}
