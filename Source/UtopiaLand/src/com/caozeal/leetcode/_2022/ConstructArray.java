package com.caozeal.leetcode._2022;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ConstructArray {

    public static void main(String[] args) {
        ConstructArray array = new ConstructArray();
        System.out.println(Arrays.stream(array.constructArray(7, 5)).boxed().map(String::valueOf).collect(Collectors.joining(";")));
    }

    public int[] constructArray(int n, int k) {
        int flag = 1;
        int step = k;
        int[] result = new int[n];
        result[0] = 1;
        for(int i=1;i<k+1;i++){
            result[i] = result[i-1] + (flag*(step--));
            flag=-flag;
        }
        for(int i=k+1;i<n;i++){
            result[i] = i+1;
        }
        return result;
    }
}
