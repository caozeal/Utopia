package com.caozeal.leetcode._2022;

public class CanBeEqual {

    public boolean canBeEqual(int[] target, int[] arr) {
        int max = 0;
        for (int i : target) {
            max = Math.max(max, i);
        }
        int[] temp = new int[max+1];
        for (int i : target) {
            temp[i] += 1;
        }
        for (int i : arr) {
            if(i > max || temp[i] == 0){
                return false;
            }
            temp[i] -= 1;
        }
        return true;
    }

    public boolean canBeEqual1(int[] target, int[] arr) {
        int[] temp = new int[1001];
        for (int i : target) {
            temp[i] += 1;
        }
        for (int i : arr) {
            if(temp[i] == 0){
                return false;
            }
            temp[i] -= 1;
        }
        return true;
    }

    public boolean canBeEqual2(int[] target, int[] arr) {
        short[] temp = new short[1001];
        for (int i : target) {
            temp[i]++;
        }
        for (int i : arr) {
            if(temp[i]-- == 0){
                return false;
            }
        }
        return true;
    }

    public boolean canBeEqual3(int[] target, int[] arr) {
        if(target.length > (1 << 7) -1){
            short[] temp = new short[1001];
            for (int i : target) {
                temp[i] += 1;
            }
            for (int i : arr) {
                if(temp[i] == 0){
                    return false;
                }
                temp[i] -= 1;
            }
            return true;
        }
        byte[] temp = new byte[1001];
        for (int i : target) {
            temp[i] += 1;
        }
        for (int i : arr) {
            if(temp[i] == 0){
                return false;
            }
            temp[i] -= 1;
        }
        return true;
    }

}
