package com.caozeal.leetcode;

public class BulbSwitch {

    public int bulbSwitch(int n) {
        for(int i =1; i<1e5; i++){
            if(n < i * i){
                return i-1;
            }
        }
        return -1;
    }
}