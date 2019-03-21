package com.caozeal.practice.concurrent.base.matrix;

/**
 * //TODO description of this class
 *
 * @author caozhiyong
 * @version 1.0.0
 * @date 2019/3/10
 */
public class MatrixMain {

    /**
     * timeConsuming: 53349 ms
     *                229397 ms
     *                16098 ms
     * @param args
     */
    public static void main(String[] args) {
        double m1[][] = MatrixGenerator.generate(2000, 2000);
        double m2[][] = MatrixGenerator.generate(2000, 2000);
        double result[][] = new double[m1.length][m2[0].length];
        long start = System.currentTimeMillis();
//        SerialMultiplier.multiply(m1, m2, result);
//        ParallelIndividualMultiplier.multiply(m1, m2, result);
//        ParallelRowMultiplier.multiply(m1, m2, result);
        ParallelGroupMultiplier.multiply(m1, m2, result);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
