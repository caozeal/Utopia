package com.caozeal.leetcode._2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupThePeople {

    public static void main(String[] args) {
        GroupThePeople groupThePeople = new GroupThePeople();
        groupThePeople.groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3});
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> tempMap = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int groupSize = groupSizes[i];
            tempMap.putIfAbsent(groupSize, new ArrayList<>());
            List<Integer> group = tempMap.get(groupSize);
            group.add(i);
            if(group.size() == groupSize){
                result.add(group);
                tempMap.put(groupSize, null);
            }
        }
        return result;
    }
}
