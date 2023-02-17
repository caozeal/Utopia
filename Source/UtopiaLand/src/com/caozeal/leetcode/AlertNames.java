package com.caozeal.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.stream.Collectors;

public class AlertNames {

    public static void main(String[] args) {
        AlertNames alertNames = new AlertNames();
        String[] keyName = {"daniel","daniel","daniel","luis","luis","luis","luis"};
        String[] keyTime = {"10:00","10:40","11:00","09:00","11:00","13:00","15:00"};
        System.out.printf(JSON.toJSONString(alertNames.alertNames(keyName, keyTime)));
    }

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<Integer, List<String >> preMap = preMap(keyName, keyTime);
        Map<String, Integer> current = new HashMap<>();
        Set<String> alert = new HashSet<>();
        for (int j = 0; j < 60; j++) {
            addName(preMap, current, alert, 0, j);
        }
        for (int i = 1; i < 24; i++) {
            for (int j = 0; j < 60; j++){
                removeName(preMap, current, alert, i, j);
                addName(preMap, current, alert, i, j);
            }
        }
        return alert.stream().sorted().collect(Collectors.toList());
    }

    private static void removeName(Map<Integer, List<String>> preMap,
                                Map<String, Integer> current,
                                Set<String> alert, int i, int j) {
        List<String> names = preMap.get((i-1)*60 + j-1);
        if(names == null || names.isEmpty()){
            return;
        }
        for (String name : names) {
            if(alert.contains(name)){
                continue;
            }
            current.put(name, current.getOrDefault(name, 0)-1);
        }
    }

    private static void addName(Map<Integer, List<String>> preMap,
                                Map<String, Integer> current,
                                Set<String> alert, int i, int j) {
        List<String> names = preMap.get(i *60 + j);
        if(names == null || names.isEmpty()){
            return;
        }
        for (String name : names) {
            if(alert.contains(name)){
                continue;
            }
            current.put(name, current.getOrDefault(name, 0)+1);
            if(current.get(name) >= 3){
                alert.add(name);
                current.remove(name);
            }
        }
    }

    private Map<Integer, List<String>> preMap(String[] keyName, String[] keyTime){
        Map<Integer, List<String>> preMap = new HashMap<>();
        for (int i = keyTime.length - 1; i >= 0; i--) {
            Integer s = parseTime(keyTime[i]);
            preMap.computeIfAbsent(s, a->new ArrayList<>());
            preMap.get(s).add(keyName[i]);
        }
        return preMap;
    }

    private Integer parseTime(String time){
        String[] split = time.split(":");
        return Integer.valueOf(split[0])*60 + Integer.valueOf(split[1]);
    }
}
