package com.caozeal.leetcode.before20230224;

public class ArrayStringsAreEqual {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int p2 = 0;
        int c2 = 0;
        for (String s1 : word1) {
            for (int i = 0; i < s1.length(); i++) {
                if(p2 == word2.length){
                    return false;
                }
                if(s1.charAt(i) != word2[p2].charAt(c2)){
                    return false;
                }
                if(++c2 == word2[p2].length()){
                    p2++;
                    c2 = 0;
                }
            }
        }
        if(p2 != word2.length){
            return false;
        }
        return true;
    }

    public boolean arrayStringsAreEqual1(String[] word1, String[] word2) {
        String a = String.join("", word1);
        String b = String.join("", word2);
        return a.equals(b);
    }
}