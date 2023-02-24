package com.caozeal.leetcode.before20230224;

public class ClimbStairs {

    public static void main(String[] args) {
        ClimbStairs stairs = new ClimbStairs();
        System.out.println(stairs.climbStairs(1000));
        System.out.println(stairs.climbStairsDynamic(1000));
    }

    public int climbStairsDynamic(int n){
        int[] _state = new int[n];
        _state[0] = 1;
        _state[1] = 1;
        for (int i = 1; i < n; i++) {
            int j = Math.min(2 * i - 1, n - 1);
            for (; j >= i-1; j--) {
                if(j+2<n){
                    _state[j+2] += _state[j];
                }
                if(j+1<n){
                    _state[j+1] += _state[j];
                    _state[j] = 0;
                }
            }
        }
        return _state[n-1];
    }

    private int[] state;


    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        state = new int[n];
        state[0] = 1;
        state[1] = 2;
        return climb(n);
    }

    private int climb(int n){
        if(state[n-1] != 0){
            return state[n-1];
        }
        int result = climb(n-1) + climb(n-2);
        state[n-1] = result;
        return result;
    }
}
