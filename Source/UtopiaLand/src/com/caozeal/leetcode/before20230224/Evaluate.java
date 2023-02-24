package com.caozeal.leetcode.before20230224;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Evaluate {

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> kl = new HashMap<>();
        for (List<String> klEntry : knowledge) {
            kl.put(klEntry.get(0), klEntry.get(1));
        }
        StringBuilder result = new StringBuilder();
        StringBuilder sb = null;
        boolean eval = false;
        for (int i = 0; i < s.length(); i++) {
            if('(' == s.charAt(i)){
                eval = true;
                sb = new StringBuilder();
                continue;
            }
            if(')' == s.charAt(i)){
                eval = false;
                result.append(kl.getOrDefault(sb.toString(), "?"));
                continue;
            }
            if(eval){
                sb.append(s.charAt(i));
                continue;
            }
            result.append(s.charAt(i));
        }
        return result.toString();
    }
}
