package com.caozeal.leetcode.before20230224;

public class MagicalString {

    public static void main(String[] args){
      MagicalString s = new MagicalString();
      System.out.println(s.magicalString(6));
    }

    public static int magicalString(int n) {
        int flag = 0;
        char[] cs = new char[n];
        int count = 1;
        cs[0] = 1;
        char current = 1;
        int result = 1;
        for (int i = 1; i < n; i++) {
            if(cs[flag] == count){
                flag++;
                count = 0;
                if(current == 1){
                    current = 2;
                }else {
                    current = 1;
                }
            }
            cs[i] = current;
            if(current == 1){
                result++;
            }
            count++;
        }
        return result;
    }

}