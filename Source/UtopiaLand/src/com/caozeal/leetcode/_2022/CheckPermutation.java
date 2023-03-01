package com.caozeal.leetcode._2022;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {

    public boolean checkPermutation(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            countMap.merge(s1.charAt(i), 1, Integer::sum);
        }
        for (int i = 0; i < s2.length(); i++) {
            Integer num = countMap.get(s2.charAt(i));
            if(num == null){
                return false;
            }
            if(num == 1){
                countMap.remove(s2.charAt(i));
            }else {
                countMap.put(s2.charAt(i), num-1);
            }
        }
        return true;
    }
}
