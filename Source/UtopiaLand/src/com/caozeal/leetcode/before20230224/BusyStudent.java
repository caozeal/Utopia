package com.caozeal.leetcode.before20230224;

public class BusyStudent {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int num = 0;
        for (int i = 0; i < startTime.length; i++) {
            if(queryTime >= startTime[i] && queryTime <= endTime[i]){
                num++;
            }
        }
        return num;
    }
}
