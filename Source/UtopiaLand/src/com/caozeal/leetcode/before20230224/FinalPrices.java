package com.caozeal.leetcode.before20230224;

public class FinalPrices {

    public static void main(String[] args) {
        FinalPrices finalPrices = new FinalPrices();
        finalPrices.finalPrices(new int[]{8,7,4,2,8,1,7,7,10,1});
    }

    public int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length-1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if(prices[j]<=prices[i]){
                    prices[i] -= prices[j];
                    break;
                }
            }
        }
        return prices;
    }
}
