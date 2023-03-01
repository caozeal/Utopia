package com.caozeal.leetcode._2022;

import java.util.HashMap;
import java.util.Map;

public class MaxEqualFreq {

    public static void main(String[] args) {
        System.out.println(maxEqualFreq(new int[]{1,2,3, 4, 5, 6}));
    }

    public static int maxEqualFreq(int[] nums) {
        int max = 1, min = 1, maxLength = 0;
        int[] freq = new int[100001];
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int count = freq[num];
            count++;
            countMap.merge(count, 1, Integer::sum);
            if(count > 1){
                countMap.merge(count-1, 1, (a, b) -> a-b);
            }
            if(count > max){
                max = count;
            }
            if(count < min && count > 1){
                min = count;
            } else if(count == min+1 && min != 0){
                if(countMap.get(count-1) == 0){
                    min = count;
                }
            }
            freq[num] = count;
            if(maxEqual(max, min, countMap.get(1), i+1, countMap.get(max))){
                maxLength = i+1;
            }
        }
        return maxLength;
    }

    private static int count(int[] freq, int aim){
        int count = 0;
        for (int i : freq) {
            if(i == aim){
                count++;
            }
        }
        return count;
    }

    private static boolean maxEqual(int max, int min, int count1, int count, int countMax){
        if(max == count || max == count-1 || count1 == count){
            return true;
        }
        if(count1 == 1){
            return min == max;
        }
        if(count1 > 1){
            return max == 2 && countMax == 1;
        }
        if(max == min && countMax == 1){
            return true;
        }
        return max - min == 1 && countMax == 1;
    }
}
