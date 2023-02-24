package com.caozeal.leetcode.before20230224;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BestHand {

    public String bestHand(int[] ranks, char[] suits) {
        Map<Integer, Integer> rankMap = new HashMap<>();
        int max = 1;
        boolean equalSuit = true;
        for (int i = 0; i < ranks.length; i++) {
            rankMap.put(ranks[i], rankMap.getOrDefault(ranks[i], 0)+1);
            if(rankMap.get(ranks[i]) > max){
                max = rankMap.get(ranks[i]);
            }
            if(equalSuit){
                equalSuit = suits[i] == suits[0];
            }
        }
        if(equalSuit){
            return "Flush";
        }
        if(max >= 3){
            return "Three of a Kind";
        }
        if(max == 2){
            return "Pair";
        }
        return "High Card";
    }
}
