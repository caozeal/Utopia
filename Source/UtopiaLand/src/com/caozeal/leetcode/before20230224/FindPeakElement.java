package com.caozeal.leetcode.before20230224;

public class FindPeakElement {

    public static void main(String[] args) {
        FindPeakElement element = new FindPeakElement();
        System.out.println(element.findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }

    public int findPeakElement(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int start = 0;
        int end = nums.length-1;
        int mid;
        while (start < end){
            mid = (start + end) >> 1;
            if(mid != 0 && nums[mid] < nums[mid-1]){
                end = mid-1;
                continue;
            }
            if(mid != nums.length-1 && nums[mid] < nums[mid+1]){
                start = mid+1;
                continue;
            }
            return mid;
        }
        return start;
    }
}
