package com.caozeal.leetcode.before20230224;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int closest = findClosest(arr, 0, arr.length-1, x);
        int i;
        int min = Math.min(closest + k, arr.length-k);
        for(i = Math.max((closest - k), 0); i< min; i++){
            if(arr[i+k] == arr[i]){
                    continue;
            }
            if(Math.abs(arr[i+k] - x) >= Math.abs(arr[i] - x)){
                break;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int j = i; j<i+k ; j++) {
            result.add(arr[j]);
        }
        return result;
    }

    private int findClosest(int[] arr, int start, int end, int x){
        if(start <= end){
            return start;
        }
        if(arr[(start+end)/2] > x){
            return findClosest(arr, start, (start+end)/2-1, x);
        } else if (arr[(start+end)/2] < x) {
            return findClosest(arr, (start+end)/2+1, end, x);
        }
        return (start+end)/2;
    }
}
