package com.caozeal.leetcode.before20230224;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomSortString {

    public String customSortString(String order, String s) {
        Map<Character, Integer> pos = new HashMap<>();
        for(int i=0; i<order.length(); i++){
            pos.put(order.charAt(i), i);
        }
        Character[] c = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            c[i] = s.charAt(i);
        }
        Arrays.sort(c, Comparator.comparingInt(a -> pos.getOrDefault(a, -1)));
        StringBuilder builder = new StringBuilder();
        for (Character character : c) {
            builder.append(character);
        }
        return builder.toString();
    }

    public String customSortString1(String order, String s) {
        int[] pos = new int[26];
        for(int i=1; i<=order.length(); i++){
            pos[order.charAt(i-1) - 'a'] = i;
        }
        Character[] c = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            c[i] = s.charAt(i);
        }
        Arrays.sort(c, Comparator.comparingInt(a -> pos[a - 'a']));
        StringBuilder builder = new StringBuilder();
        for (Character character : c) {
            builder.append(character);
        }
        return builder.toString();
    }

    public String customSortString2(String order, String s) {
        int[] pos = new int[26];
        for(int i=1; i<=s.length(); i++){
            pos[s.charAt(i-1) - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            for(int j=0; j<pos[order.charAt(i) - 'a']; j++){
                builder.append(order.charAt(i));
            }
            pos[order.charAt(i) - 'a'] = 0;
        }
        for (int i = 0; i < pos.length; i++) {
            for(int j=0; j<pos[i]; j++){
                builder.append((char) (i + 'a'));
            }
        }
        return builder.toString();
    }
}
