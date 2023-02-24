package com.caozeal.leetcode.before20230224;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager {

    private final Map<String, Integer> expiredTimeMap;

    private final int timeToLive;

    public AuthenticationManager(int timeToLive) {
        expiredTimeMap = new HashMap<>();
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        expiredTimeMap.put(tokenId, currentTime+timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        if(expiredTimeMap.get(tokenId) == null || expiredTimeMap.get(tokenId) <= currentTime){
            return;
        }
        expiredTimeMap.put(tokenId, currentTime+timeToLive);
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (Map.Entry<String, Integer> entry : expiredTimeMap.entrySet()) {
            if(entry.getValue() > currentTime){
                count++;
            }
        }
        return count;
    }
}
