package com.caozeal.leetcode.before20230224;

public class IsIdealPermutation {

    public boolean isIdealPermutation(int[] nums) {
        if(nums.length <= 2){
            return true;
        }
        int min = nums[nums.length-1];
        if(nums[nums.length-3] > min){
            return false;
        }
        for (int i = nums.length - 2; i >= 2; i--) {
            min = Math.min(min, nums[i]);
            if(nums[i-2] > min){
                return false;
            }
        }
        return true;
    }
}
