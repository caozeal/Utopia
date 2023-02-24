package com.caozeal.leetcode.before20230224;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CanFormArray {

    public static void main(String[] args) {
        CanFormArray array = new CanFormArray();
        System.out.println(array.canFormArray3(new int[]{91,4,64,78}, new int[][]{{78},{4,64},{91}}));
    }

    public boolean canFormArray3(int[] arr, int[][] pieces) {
        int[][] p = new int[100][];
        for (int[] piece : pieces) {
            p[piece[0]-1] = piece;
        }
        for (int i = 0; i < arr.length; i++) {
            int[] target = p[arr[i]-1];
            if(target == null){
                return false;
            }
            for (int j = 1; j < target.length; j++) {
                if(target[j] != arr[++i]){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean canFormArray2(int[] arr, int[][] pieces) {
        Map<Integer, int[]> p = new HashMap<>();
        for (int[] piece : pieces) {
            p.put(piece[0], piece);
        }
        for (int i = 0; i < arr.length; i++) {
            int[] target = p.get(arr[i]);
            if(target == null){
                return false;
            }
            for (int j = 1; j < target.length; j++) {
                if(target[j] != arr[++i]){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean canFormArray1(int[] arr, int[][] pieces) {
        int i = 0;
        boolean process = false;
        while (i<arr.length){
            for (int[] piece : pieces) {
                if(i>=arr.length){
                    return true;
                }
                if(piece[0] == arr[i]){
                    for (int j = 1; j < piece.length; j++) {
                        if(piece[j] != arr[++i]){
                            return false;
                        }
                    }
                    i++;
                    process = true;
                }
            }
            if(!process){
                return false;
            }else {
                process = false;
            }
        }
        return true;
    }

    public boolean canFormArray(int[] arr, int[][] pieces) {
        Arrays.sort(pieces, Comparator.comparingInt(i -> i[0]));
        int i = 0;
        while (i<arr.length){
            i = search(arr, i, pieces, 0, pieces.length-1);
            if(i==-1){
                return false;
            }
        }
        return true;
    }

    private int search(int[] arr, int i, int[][] pieces, int start, int end){
        if(start > end){
            return -1;
        }
        int mid = (start + end)>> 1;
        if(pieces[mid][0] == arr[i]){
            for (int j = 1; j < pieces[mid].length; j++) {
                if(pieces[mid][j] != arr[++i]){
                    return -1;
                }
            }
            return i+1;
        }
        if(pieces[mid][0] > arr[i]){
            return search(arr, i, pieces, start, mid-1);
        }
        return search(arr, i, pieces, mid+1, end);
    }
}
