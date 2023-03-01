package com.caozeal.leetcode._2022;

public class MinOperations {

    public int minOperations(String[] logs) {
        int deep = 0;
        for (String log : logs) {
            if(log.charAt(1) == '.'){
                if(deep > 0){
                    deep--;
                }
                continue;
            }
            if(log.charAt(0) == '.'){
                continue;
            }
            deep++;
        }
        return deep;
    }
}
