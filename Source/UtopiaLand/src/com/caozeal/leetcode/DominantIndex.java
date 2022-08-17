package com.caozeal.leetcode;

public class DominantIndex {

    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[]{3, 0, 0, 2}));
    }

    public static int dominantIndex(int[] nums) {
        int largest=0, larger = -1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[largest]){
                larger = largest;
                largest = i;
                continue;
            }
            if(larger == -1 || nums[i] > nums[larger]){
                larger = i;
            }
        }
        if(nums[larger] == nums[largest] || nums[larger]*2 <= nums[largest]){
            return largest;
        }
        return -1;
    }
}
