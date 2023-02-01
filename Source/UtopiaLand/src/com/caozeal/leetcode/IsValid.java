package com.caozeal.leetcode;

import java.util.ArrayDeque;

public class IsValid {

    public boolean isValid(String s) {
        ArrayDeque<Character> queue = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if('(' == c || '{' == c || '[' == c){
                queue.addLast(c);
                continue;
            }
            if(queue.isEmpty()){
                return false;
            }
            Character _c = queue.pollLast();
            if((')' == c && '(' == _c) || ('}' == c && '{' == _c) || (']' == c && '[' == _c)){
                continue;
            }
            return false;
        }
        return queue.isEmpty();
    }
}