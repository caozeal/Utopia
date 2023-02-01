package com.caozeal.leetcode;

import java.util.Arrays;

public class ClimbStairs {

    public static void main(String[] args) {
        ClimbStairs stairs = new ClimbStairs();
        System.out.println(stairs.climbStairs(4));
    }

    public static int climbStairs(int n) {
        int[] store = new int[n];
        store[0] = 1;
        store[1] = 1;
        for (int i1 : store) {
            System.out.print(i1);
            System.out.print(",");
        }
        System.out.println();
        for(int i=1; i<n; i++){
            int max = Math.min(2*i-2, n-2);
            for(int j=max; j>=i-1; j--){
                if(j+2 < n){
                    store[j+2] = store[j+2] + store[j];
                }
                store[j+1] = store[j+1] + store[j];
            }
            for (int i1 : store) {
                System.out.print(i1);
                System.out.print(",");
            }
            System.out.println();
        }
        return store[n-1];
    }
}
