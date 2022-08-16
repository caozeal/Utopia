package com.caozeal.leetcode;

public class Search {

    public static void main(String[] args) {
        Search search = new Search();
        System.out.println(search.search1(new int[]{4, 0, 1, 2, 3}, 0));
    }

    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length-1, target);
    }

    private int search(int[] nums, int start, int end, int target){
        if(start > end){
            return -1;
        }
        if(nums[start] == target){
            return start;
        }
        if(nums[end] == target){
            return end;
        }
        if(start == end){
            return -1;
        }
        int mid = (start+end)/2;
        if(target == nums[mid]){
            return mid;
        }
        if(nums[start] < nums[end]){
            if(target > nums[mid]){
                return search(nums, mid+1, end-1, target);
            }else{
                return search(nums, start+1, mid-1, target);
            }
        }
        if(nums[mid] < nums[end]){
            if(target < nums[mid] || target > nums[start]){
                return search(nums, start+1, mid-1, target);
            }else {
                return search(nums, mid+1, end-1, target);
            }
        }
        if(target < nums[end] || target > nums[mid]){
            return search(nums, mid+1, end-1, target);
        }else{
            return search(nums, start+1, mid-1, target);
        }

    }

    public int search1(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            int mid = ((high + low) >> 1);
            if(nums[mid] == target){
                return mid;
            }
            if((nums[low] <= target && target < nums[mid])
                    || (nums[low] > nums[mid] && (nums[mid] > target || target > nums[high]))
                    || high == mid ){
                high = mid - 1;
                continue;
            }
            low = mid + 1;
        }
        return -1;
    }
}
