package com.caozeal.leetcode.before20230224;

import java.util.HashSet;
import java.util.Set;

public class MaxChunksToSorted {

    public static void main(String[] args) {
        MaxChunksToSorted sorted = new MaxChunksToSorted();
        System.out.println(sorted.maxChunksToSorted(new int[]{2,1,0,3,4}));
    }

    public int maxChunksToSorted(int[] arr) {
        int result = 0;
        Set<Integer> contrast = new HashSet<>();
        int pivot = 0;
        for (int i = 0; i < arr.length; i++) {
            contrast.add(i);
            while (pivot < arr.length && contrast.contains(arr[pivot])){
                contrast.remove(arr[pivot++]);
            }
            if(contrast.isEmpty()){
                result++;
            }
        }
        return result;
    }
}
