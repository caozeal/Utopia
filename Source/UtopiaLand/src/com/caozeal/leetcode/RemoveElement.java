package com.caozeal.leetcode;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int refresh = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[refresh++] = nums[i];
            }
        }
        return refresh+1;
    }
}
