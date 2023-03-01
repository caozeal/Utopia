package com.caozeal.leetcode._2022;

public class MinTime {

    public static void main(String[] args) {
        MinTime minTime = new MinTime();
        System.out.println(minTime.minTime(new int[]{1, 2, 3, 3}, 2));
    }

    public int minTime(int[] time, int m) {
        if(time.length <= m){
            return 0;
        }
        int total = 0;
        for (int i : time) {
            total += i;
        }
        int high = total;
        int low = 0;
        int middle;
        while (low < high - 1){
            middle = (high + low) >> 1;
            if(!check(time, middle, m)){
                low = middle;
            }else {
                high = middle;
            }
        }
        return low;
    }

    private boolean check(int[] time, int t, int m){
        int total = 0,max = 0, day = 0;
        for (int i : time) {
            if(i > max){
                max = i;
                total += max;
            }else {
                total += i;
            }
            if(total >= t){
                day++;
                total = 0;
                max = 0;
            }
        }
        return ++day < m;
    }
}
