package com.caozeal.leetcode._2022;

public class Search2 {

    public static void main(String[] args) {
        Search2 search = new Search2();
        System.out.println(search.search(new int[]{2, 2, 2, 0, 0, 1}, 0));
    }

    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            int mid = ((high + low) >> 1);
            if(nums[mid] == target || nums[low] == target || nums[high] == target){
                return true;
            }
            if(nums[low] == nums[high] && nums[high] == nums[mid]){
                high--;
                low++;
                continue;
            }
            if((nums[low] < target && target < nums[mid])
                    || (nums[low] > nums[mid] && (nums[mid] > target || target > nums[high]))
                    || high == mid ){
                high = mid - 1;
                low++;
                continue;
            }
            low = mid + 1;
            high--;
        }
        return false;
    }
}
