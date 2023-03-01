package com.caozeal.leetcode._2022;

public class TotalFruit {

    public static void main(String[] args) {
        TotalFruit fruit = new TotalFruit();
        System.out.println(fruit.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }

    public int totalFruit(int[] fruits) {
        if(fruits.length == 1){
            return 1;
        }
        int current = fruits[0];
        int last = -1;
        int pre = 0;
        int maxLength = 1;
        int length = 1;
        for (int i = 1; i < fruits.length; i++) {
            if(fruits[i] == current){
                length++;
            }else if(fruits[i] == last || last == -1){
                length++;
                last = current;
                current = fruits[i];
                pre = i;
            }else {
                length = i - pre + 1;
                last = current;
                current = fruits[i];
                pre = i;
            }
            if(length > maxLength){
                maxLength = length;
            }
        }
        return maxLength;
    }
}
