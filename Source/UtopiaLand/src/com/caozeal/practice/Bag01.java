package com.caozeal.practice;

import java.util.HashSet;
import java.util.Set;

public class Bag01 {


    // 回溯算法实现。注意：我把输入的变量都定义成了成员变量。
    private int maxW = Integer.MIN_VALUE; // 结果放到maxW中
    private int[] weight = {2, 2, 4, 6,3};  // 物品重量
    private int n = 5; // 物品个数
    private int w = 9; // 背包承受的最大重量

    public int getMaxW() {
        return maxW;
    }

    public static void main(String[] args) {
        Bag01 bag01 = new Bag01();
//        bag01.f(0, 0);
        bag01.dynamicProgram();
        System.out.printf("max: " + bag01.getMaxW());
    }

    public void dynamicProgram(){
        boolean[] states = new boolean[w+1];
        states[0] = true;
        for (int i : weight) {
            for (int j = states.length - 1; j >= 0; j--) {
                if(states[j] && j+i <= w){
                    states[j+i] = true;
                }
            }
        }
        for (int i = states.length - 1; i >= 0; i--) {
            if(states[i]){
                maxW = i;
                return;
            }
        }
    }

    private final Set<String> memo = new HashSet<>();

    public void f(int i, int cw) { // 调用f(0, 0)
        String key = String.format("%s_%s", i, cw);
        if(memo.contains(key)){
            return;
        }
        memo.add(key);
        if (cw == w || i == n) { // cw==w表示装满了，i==n表示物品都考察完了
            if (cw > maxW) maxW = cw;
            return;
        }
        f(i+1, cw); // 选择不装第i个物品
        if (cw + weight[i] <= w) {
            f(i+1,cw + weight[i]); // 选择装第i个物品
        }
    }
}
