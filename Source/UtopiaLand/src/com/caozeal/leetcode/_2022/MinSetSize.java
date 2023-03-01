package com.caozeal.leetcode._2022;

import java.util.Arrays;
import java.util.HashMap;

public class MinSetSize {

    public static void main(String[] args) {
        MinSetSize setSize = new MinSetSize();
        System.out.println(setSize.minSetSize1(new int[]{3,3,3,3,5,5,5,2,2,7}));
    }

    public int minSetSize(int[] arr) {
        int[] times = new int[100000];
        int max = 0;
        int min = 100000;
        for(int i : arr){
            times[i] += 1;
            if(i>max){
                max = i;
            }
            if(i<min){
                min=i;
            }
        }
        Arrays.sort(times, min, max+1);
        int count = 0;
        for(int i=max; i>=min; i--){
            count += times[i];
            if(count > arr.length/2){
                return max-i+1;
            }
        }
        return -1;
    }

    public int minSetSize1(int[] arr) {
        HashMap<Integer, Integer> times = new HashMap<>(arr.length*4/3);
        for(int i : arr){
            times.merge(i, 1, Integer::sum);
        }
        Integer[] array = times.values().toArray(new Integer[0]);
        Arrays.sort(array);
        int count = 0;
        for(int i=array.length-1; i>=0; i--){
            count += array[i];
            if(count >= arr.length/2){
                return array.length-i;
            }
        }
        return -1;
    }
}
