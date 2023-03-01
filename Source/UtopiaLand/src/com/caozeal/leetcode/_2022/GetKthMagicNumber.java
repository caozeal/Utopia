package com.caozeal.leetcode._2022;

//1,  3,5,7,  9, 15, 21, 25,27, 35, 49
//1 , 3, 6, 10, 20
//1, 4, 10, 20, 40
public class GetKthMagicNumber {

    public static void main(String[] args) {
        GetKthMagicNumber number = new GetKthMagicNumber();
        System.out.println(number.getKthMagicNumber(10));
    }

    public int getKthMagicNumber(int k) {
        int[] dp = new int[k];
        dp[0] = 1;
        int p3 = 0, p5 = 0, p7 = 0;
        for (int i = 1; i < k; i++) {
            int num3 = dp[p3] * 3, num5 = dp[p5] * 5, num7 = dp[p7] * 7;
            dp[i] = Math.min(Math.min(num3, num5), num7);
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
            if (dp[i] == num7) {
                p7++;
            }
        }
        return dp[k-1];
    }
}
