package com.caozeal.exam;

import java.util.Scanner;

public class Main{

    public static void reverseWords(String s){
        if(s == null){
            return;
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
        System.out.println(s);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = "";
        while (scanner.hasNextLine()){
            s = scanner.nextLine();
            reverseWords(s);
        }
//        String s = "3344  344    ";
    }
}
