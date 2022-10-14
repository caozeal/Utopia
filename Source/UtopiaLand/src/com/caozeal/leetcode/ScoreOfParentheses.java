package com.caozeal.leetcode;

import java.util.ArrayDeque;

public class ScoreOfParentheses {

    public static void main(String[] args) {
        ScoreOfParentheses scoreOfParentheses = new ScoreOfParentheses();
        System.out.println(scoreOfParentheses.scoreOfParentheses("(()(()))"));
    }

    public int scoreOfParentheses(String s) {
        int[] c = new int[s.length()/2];
        int pointer = 0;
        c[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if('(' == s.charAt(i)){
                c[++pointer] = 0;
                continue;
            }
            if(c[pointer] == 0){
                c[pointer] = 1;
            }else {
                c[pointer-1] = c[pointer]*2;
                pointer--;
            }
            if (pointer-1 >=0 && c[pointer-1] >0){
                c[pointer-1] = c[pointer-1] + c[pointer];
                pointer--;
            }

        }
        return c[0];
    }
}
