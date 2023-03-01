package com.caozeal.leetcode._2022;

public class MaximumSwap {

    public static void main(String[] args) {
        MaximumSwap swap = new MaximumSwap();
        System.out.println(swap.maximumSwap(9973));
    }

    public int maximumSwap(int num) {
        if(num < 10){
            return num;
        }
        int length = 9;
        int mod = 100000000;
        while (num/mod == 0){
            length--;
            mod = mod/10;
        }
        int[] tran = new int[length];
        tran[0] = num/mod;

        for(int i=1; i<tran.length; i++){
            mod = mod/10;
            tran[i] = (num%(mod * 10))/mod;
        }
        int[] pos = new int[10];
        for (int i = 0; i < tran.length; i++) {
            pos[tran[i]] = i;
        }
        int pivot = 0;
        for (int i = 9; i >= 0; i--) {
            while (pivot < tran.length && tran[pivot] == i){
                pivot++;
            }
            if(pos[i] != 0 && pos[i] > pivot){
                tran[pivot] = tran[pos[i]] + tran[pivot];
                tran[pos[i]] = tran[pivot] - tran[pos[i]];
                tran[pivot] = tran[pivot] - tran[pos[i]];
                break;
            }
        }
        int result = 0;
        for (int i = tran.length -1 ; i >= 0; i--) {
            result += (tran[i]*mod);
            mod *= 10;
        }
        return result;
    }
}
