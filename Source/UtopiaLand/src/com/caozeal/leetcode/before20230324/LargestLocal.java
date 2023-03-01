package com.caozeal.leetcode.before20230324;

public class LargestLocal {

    public int[][] largestLocal(int[][] grid) {
        int[][] result = new int[grid.length-2][grid.length-2];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                int max = 0;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if(grid[i+k][j+l] > max){
                            max = grid[i+k][j+l];
                        }
                    }
                }
                result[i][j] = max;
            }
        }
        return result;
    }
}
