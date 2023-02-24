package com.caozeal.leetcode.before20230224;

public class LargestAltitude {

    public int largestAltitude(int[] gain) {
        int max = 0;
        int cur = 0;
        for (int i : gain) {
            cur+=i;
            if(cur > max){
                max = cur;
            }
        }
        return max;
    }
}
