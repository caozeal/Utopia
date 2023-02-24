package com.caozeal.leetcode.before20230224;

import com.alibaba.fastjson.JSON;

public class CountBits {

    public static void main(String[] args) {
        CountBits countBits = new CountBits();
        System.out.printf(JSON.toJSONString(countBits.countBits(5)));
    }

    public int[] countBits(int n) {
        int[] result = new int[n+1];
        result[0] = 0;
        int pow = 1;
        for (int i = 1; i < n + 1; i++) {
            if(i - pow < pow){
                result[i] = result[i-pow] + 1;
                continue;
            }
            result[i] = 1;
            pow = pow << 1;
        }
        return result;
    }
}
