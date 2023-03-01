package com.caozeal.leetcode._2022;

import java.util.ArrayDeque;

public class IsFlippedString {

    public static void main(String[] args) {
        IsFlippedString string  = new IsFlippedString();
        System.out.println(string.isFlippedString1("waterbottle", "erbottlewat"));
    }

    public boolean isFlippedString1(String s1, String s2){
        int length = s2.length();
        if(length == 0){
            return s1.length() == 0;
        }
        if(s1.length() != length){
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(0) == s2.charAt(length -1-i) && s1.charAt(i) == s2.charAt(length -1)){
                if(s1.substring(0, i+1).equals(s2.substring(length-1-i)) && s1.substring(i+1).equals(s2.substring(0, length-1-i))){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isFlippedString(String s1, String s2) {
        if(s2.length() == 0){
            return s1.length() == 0;
        }
        if(s2.length() == 1){
            return s1.equals(s2);
        }
        if(s1.length() != s2.length()){
            return false;
        }
        char first = s2.charAt(0);
        ArrayDeque<Integer> position = new ArrayDeque<>();
        boolean check = false;
        int i = 0;
        int j = 0;
        while (i < s2.length()){
            if(s1.charAt(i) == first){
                if(check){
                    position.addLast(i);
                }else {
                    check = true;
                }
            }
            if(check){
                if(s1.charAt(i++) != s2.charAt(j++)){
                    if(!position.isEmpty()){
                        i = position.pollFirst();
                    }
                    check = false;
                    j = 0;
                }
            }else {
                i++;
            }
        }
        if(j == 0){
            return false;
        }else {
            i = 0;
            while (j < s2.length()){
                if(s1.charAt(i++) != s2.charAt(j++)){
                    return false;
                }
            }
        }
        return true;
    }
}
