package com.caozeal.leetcode.before20230324;

import java.util.*;
import java.util.stream.Collectors;

public class MergeSimilarItems {

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> merge = new HashMap<>();
        for (int[] item : items1) {
            merge.put(item[0], item[1]);
        }
        for (int[] item2 : items2) {
            if(merge.containsKey(item2[0])){
                merge.put(item2[0], item2[1] + merge.get(item2[0]));
            } else {
                merge.put(item2[0], item2[1]);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : merge.entrySet()) {
            result.add(Arrays.asList(e.getKey(), e.getValue()));
        }
        return result.stream().sorted(Comparator.comparingInt(r -> r.get(0))).collect(Collectors.toList());
    }

    public List<List<Integer>> mergeSimilarItems1(int[][] items1, int[][] items2) {
        int[] backup = new int[1001];
        for (int[] item : items1) {
            backup[item[0]] = item[1];
        }
        for (int[] item2 : items2) {
            backup[item2[0]] = backup[item2[0]] + item2[1];
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i < backup.length; i++) {
            if(backup[i] != 0){
                result.add(Arrays.asList(i, backup[i]));
            }
        }
        return result;
    }
}
