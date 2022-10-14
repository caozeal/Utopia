package com.caozeal.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CanPartitionKSubsets {

    public static void main(String[] args) {
        CanPartitionKSubsets subsets = new CanPartitionKSubsets();
        System.out.println(subsets.canPartitionKSubsets(new int[]{4,5,9,3,10,2,10,7,10,8,5,9,4,6,4,9}, 5));
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if(sum%k != 0){
            return false;
        }
        int average = sum/k;
        Arrays.sort(nums);
        for (int i = nums.length-1; i >= 0; i--) {
            if(nums[i]==0){
                continue;
            }
            int num = nums[i];
            if(num > average){
                return false;
            }
            nums[i] = 0;
            int remain = average - num;
            if(!process(remain, nums, i)){
                return false;
            }
        }
        return true;
    }

    private boolean process(int remain, int[] nums, int i){
        if(remain == 0){
            return true;
        }
        while(i>=0){
            if(nums[i] == 0){
                i--;
                continue;
            }
            if(process(remain-nums[i], nums, i-1)){
                nums[i] = 0;
                return true;
            }
            i--;
        }
        return false;
    }
}
