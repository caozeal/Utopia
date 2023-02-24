package com.caozeal.leetcode.before20230224;

import java.util.HashMap;
import java.util.Map;

public class RearrangeCharacters {

    public int rearrangeCharacters(String s, String target) {
        Map<Character, Pair> map = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            Pair pair = map.get(target.charAt(i));
            if(pair == null){
                map.put(target.charAt(i), new Pair());
                continue;
            }
            pair.target++;
        }
        for (int i = 0; i < s.length(); i++) {
            Pair pair = map.get(s.charAt(i));
            if(pair != null){
                pair.all++;
            }
        }
        return map.values().stream().mapToInt(Pair::getTimes).min().orElse(0);
    }

    static class Pair{
        int target = 1;

        int all;

        int getTimes(){
            return all / target;
        }
    }
}
