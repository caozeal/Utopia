package com.caozeal.leetcode;

public class CheckIfPangram {

    public boolean checkIfPangram(String sentence) {
        boolean[] b = new boolean[26];
        for (int i = 0; i < sentence.length(); i++) {
            b[sentence.charAt(i)-'a'] = true;
        }
        for (boolean b1 : b) {
            if(!b1){
                return false;
            }
        }
        return true;
    }

    public boolean checkIfPangram1(String sentence) {
        int n = 0;
        for (int i = 0; i < sentence.length(); i++) {
            n |= 1 << (sentence.charAt(i)-'a');
        }
        return n == (1 << 26) -1 ;
    }
}
