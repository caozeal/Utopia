package com.caozeal.leetcode;

public class SearchRange {

    public static void main(String[] args) {
        SearchRange range = new SearchRange();
        range.searchRange(new int[]{5,7,7,8,8,10}, 8);
    }


    public int[] searchRange(int[] nums, int target) {
        return search(nums, 0, nums.length-1, target);
    }

    private int[] search(int[] nums, int start, int end, int target){
        if(start > end){
            return new int[]{-1, -1};
        }
        int mid = (start + end) >> 1;
        if(nums[mid] > target){
            return search(nums, start, mid-1, target);
        }
        if(nums[mid] < target){
            return search(nums, mid+1, end, target);
        }
        return new int[]{searchHead(nums, start, mid, target), searchTail(nums, mid, end, target)};
    }

    private int searchHead(int[] nums, int start, int end, int target){
        if(end == 0||nums[end-1]!=target){
            return end;
        }
        int mid = (start + end) >> 1;
        if(nums[mid] < target){
            return searchHead(nums, mid+1, end, target);
        }
        return searchHead(nums, start, mid-1, target);
    }

    private int searchTail(int[] nums, int start, int end, int target){
        if(start == nums.length-1||nums[start+1]!=target){
            return start;
        }
        int mid = (start + end + 1) >> 1;
        if(nums[mid] > target){
            return searchTail(nums, start, mid-1, target);
        }
        return searchTail(nums, mid, end, target);
    }
}
