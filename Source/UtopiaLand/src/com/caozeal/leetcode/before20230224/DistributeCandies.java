package com.caozeal.leetcode.before20230224;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {

    public int distributeCandies(int[] candyType) {
        Set<Integer> type = new HashSet<>();
        for (int i : candyType) {
            type.add(i);
        }
        return Math.min(type.size(), candyType.length/2);
    }

    public int distributeCandies1(int[] candyType) {
        boolean[] type = new boolean[200000];
        int total = 0;
        for (int i : candyType) {
            if(!type[i+100000]){
                total++;
                type[i+100000] = true;
            }
        }
        return Math.min(total, candyType.length/2);
    }
}
