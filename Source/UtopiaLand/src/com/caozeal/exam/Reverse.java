package com.caozeal.exam;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Reverse {

    public static String reverseWords(String s){
        if(s == null){
            return null;
        }
        String[] sArray = s.split(" ");
        StringBuilder aim = new StringBuilder();
        for(int i = sArray.length - 1; i>=0; i--){
            String temp = sArray[i];
            if("".equals(temp)){
                continue;
            }
            aim.append(temp);
            aim.append(" ");
        }
        s = aim.toString().trim();
        return s;
    }

    public static void reverseWords(StringBuilder s){
        if(s == null){
            return;
        }
        String orign = s.toString();
        String[] sArray = orign.split(" ");
        StringBuilder aim = new StringBuilder();
        for(int i = sArray.length - 1; i>=0; i--){
            String temp = sArray[i];
            if("".equals(temp)){
                continue;
            }
            aim.append(temp);
            aim.append(" ");
        }
        s.delete(0, s.length());
        s.append(aim.toString().trim());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
        String s = " the sky is    blue   ";
        StringBuilder builder = new StringBuilder(s);
        reverseWords(builder);
        System.out.println(builder);
    }
}
