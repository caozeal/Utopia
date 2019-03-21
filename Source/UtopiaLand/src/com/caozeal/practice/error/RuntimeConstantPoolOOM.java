package com.caozeal.practice.error;

public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();//true
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();//false
        System.out.println(str2.intern() == str2);
    }
}
