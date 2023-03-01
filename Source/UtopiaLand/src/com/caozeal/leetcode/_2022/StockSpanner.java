package com.caozeal.leetcode._2022;

import java.util.ArrayList;
import java.util.List;

public class StockSpanner {

    public static void main(String[] args){
      StockSpanner sp = new StockSpanner();
      sp.next(31);
      sp.next(41);
      sp.next(48);
      sp.next(59);
      sp.next(79);
    }

    private List<Pair> values;
    public StockSpanner() {
        values = new ArrayList<>();
    }

    public int next(int price) {
        int i = values.size()-1;
        Pair pair = new Pair();
        pair.val = price;
        pair.nums = 1;
        values.add(pair);
        while (i >= 0){
            Pair value = values.get(i);
            Integer val = value.val;
            Integer nums = value.nums;
            if(val > price){
                break;
            }
            pair.nums = pair.nums + value.nums;
            i -= nums;
        }
        System.out.println(pair.nums);
        return pair.nums;
    }

    static class Pair{
        private Integer val;

        private Integer nums;
    }
}