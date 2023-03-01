package com.caozeal.leetcode._2022;

import java.util.HashSet;
import java.util.Set;

public class FlipLights {

    public static void main(String[] args) {
        FlipLights lights = new FlipLights();
        System.out.println(lights.flipLights(4, 2));
    }

    public int flipLights(int n, int presses) {
//        if(presses == 0){
//            return 1;
//        }
//        if(n == 1){
//            return 2;
//        }
//        if(n == 2 && presses == 1){
//            return 3;
//        }
//        if(n == 2){
//            return 4;
//        }
//        if(presses == 1){
//            return 4;
//        }
//        if(presses == 2){
//            return 7;
//        }
//        if(presses >= 3){
//            return 8;
//        }
        int a = 7;
        int b = 2;
        int c = 5;
        int d = 4;
        Set<Integer> result = new HashSet<>();
        Set<Integer> _result = new HashSet<>();

        result.add(0);
        for(int i=0; i<presses; i++){
            for (Integer r : result) {
                _result.add(r^a);
                _result.add(r^b);
                _result.add(r^c);
                _result.add(r^d);
            }
            result = _result;
            _result = new HashSet<>();
        }
        if(n >= 3){
            return result.size();
        }
        for (Integer r : result) {
            _result.add(r >> (3-n));
        }
        return _result.size();
    }
}
