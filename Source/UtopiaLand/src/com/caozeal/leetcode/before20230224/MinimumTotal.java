package com.caozeal.leetcode.before20230224;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumTotal {

    public static void main(String[] args) {
        MinimumTotal total = new MinimumTotal();
        List<List<Integer>> tr = new ArrayList<>();
        tr.add(Arrays.asList(-1));
        tr.add(Arrays.asList(2,3));
        tr.add(Arrays.asList(1,-1,-3));
        total.minimumTotal(tr);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] level = new int[triangle.size()];
        int current =0;
        int next = 0;
        level[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size()-1; j++) {
                if(j == 0){
                    current = level[0];
                    level[0] = current + triangle.get(i).get(0);
                    next = level[1];
                    level[1] = current + triangle.get(i).get(1);
                    current = next;
                }else {
                    if(current + triangle.get(i).get(j) < level[j]){
                        level[j] = current + triangle.get(i).get(j);
                    }
                    next = level[j+1];
                    level[j+1] = current + triangle.get(i).get(j+1);
                    current = next;
                }
            }
        }
        int min = level[0];
        for (int i : level) {
            if(i < min){
                min = i;
            }
        }
        return min;
    }
}
