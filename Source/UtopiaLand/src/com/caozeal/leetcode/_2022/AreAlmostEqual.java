package com.caozeal.leetcode._2022;

public class AreAlmostEqual {

    public static void main(String[] args) {
        AreAlmostEqual equal = new AreAlmostEqual();
        System.out.println(equal.areAlmostEqual("aeeeee", "aaeeee"));
    }

    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)){
            return true;
        }
        int pointer = -1;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) == s2.charAt(i)){
                continue;
            }
            if(pointer == -1){
                pointer = i;
            }else if(pointer == -2){
                return false;
            }else if(s1.charAt(pointer) == s2.charAt(i) && s1.charAt(i) == s2.charAt(pointer)){
                pointer = -2;
            }else {
                return false;
            }
        }
        return pointer < 0;
    }
}
