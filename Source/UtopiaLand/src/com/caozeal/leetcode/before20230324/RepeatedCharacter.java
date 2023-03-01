package com.caozeal.leetcode.before20230324;

import java.util.HashSet;
import java.util.Set;

public class RepeatedCharacter {

    public char repeatedCharacter(String s) {
        boolean[] backup = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            int v = s.charAt(i) - 'a';
            if(backup[v]){
                return s.charAt(i);
            }
            backup[v] = true;
        }
        return 'a';
    }

    public char repeatedCharacter1(String s) {
        Set<Character> backup = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if(backup.contains(s.charAt(i))){
                return s.charAt(i);
            }
            backup.add(s.charAt(i));
        }
        return 'a';
    }
}
