package com.caozeal.leetcode.before20230224;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SoupServings {

    public static void main(String[] args) {
        SoupServings soupServings = new SoupServings();
        System.out.println(soupServings.soupServings(50));
    }

    public double soupServings(int n) {
        return serving(n, n);
    }

    Map<Integer, Map<Integer, Double>> result = new HashMap<>();

    private double serving(int a, int b){
        if(result.get(a) != null && result.get(a).get(b) != null){
            return result.get(a).get(b);
        }
        if(a <= 0 && b <= 0){
            return 0.5;
        }
        if(a <= 0){
            return 1d;
        }
        if(b <= 0){
            return 0d;
        }
        double p1 = serving(a-100, b);
        double p2 = serving(a-75, b-25);
        double p3 = serving(a-50, b-50);
        double p4 = serving(a-25, b-75);
        double re = p1*0.25 + p2*0.25 + p3*0.25 + p4*0.25;
        result.computeIfAbsent(a, k -> new HashMap<>());
        result.get(a).put(b, re);
        return  re;
    }

    private double serving(int n){
        int a = n;
        int b = n;
        List<Save> saves = new ArrayList<>();
        saves.add(new Save(a, b, 1));
        saves.add(new Save(0, 0, 0));
        while (saves.size() > 1){
            for (int i = saves.size() - 1; i >= 0; i--) {

            }
        }
        return 1;
    }

    static class Save{
        int a;

        int b;

        double percent;

        public Save(int a, int b, double percent) {
            this.a = a;
            this.b = b;
            this.percent = percent;
        }
    }
}
