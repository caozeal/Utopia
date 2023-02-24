package com.caozeal.leetcode.before20230224;

import java.util.Arrays;

/**
 * 石头博弈
 * {2, 7, 9, 4, 4}
 *
 * 1,2,3,4,5,100
 *
 * @author Zhiyong Cao
 * @since 1.0.0
 */
public class StoneGameII {


    public static void main(String[] args) {
        StoneGameII gameII = new StoneGameII();
        System.out.printf("" + gameII.stoneGameII(new int[]{86,11,7,6,46,37,72,67,33,25,54,45}));
    }

    public int stoneGameII(int[] piles) {
        backup = new int[piles.length][piles.length/2];
        int sum = Arrays.stream(piles).sum();
        int max = max(piles, 0, 1, sum);
        return max;
    }

    int[][] backup;

    private int max(int[] piles, int index, int m, int sum){
        if(index + 2*m >= piles.length){
            return sum;
        }
        if(backup[index][m] != 0){
            return backup[index][m];
        }
        int max = 0;
        int alice = 0;
        for (int i = 0; i < 2*m; i++) {
            if(index+i >= piles.length){
                break;
            }
            alice += piles[index+i];
            max = Math.max(max, sum - max(piles, index+i+1, Math.max(i+1, m), sum-alice));
        }
        backup[index][m] = max;
        return max;
    }
}
