package com.caozeal.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TrimMean {

    public static void main(String[] args) {
        TrimMean mean = new TrimMean();
        System.out.println(mean.trimMean1(new int[]{77014,31380,71838,27969,33049,3898,67868,64702,53537,52816,17519,28838,59051,13230,73001,33827,32240,46354,8855,30273,39390,86556,50290,16477,99563,44257,7351,81523,63513,82380,29575,41828,51542,2780,54375,28881,64406,61289,80186,54848,39868,3835,57351,80742,87340,87345,52223,32533,79419,78700,53644,55640,77066,48359,87122,13696,64113,94355,37562,14690,4705,50581,88483,84764,69135,84169,91375,85633,15406,17388,25798,27145,96021,32339,92062,60871,46661,87201,31021,61525,58445,9696,57520,78762,24725,17911,9614,99570,81627,53031,61386,97294,30116,38049,80132,75757,11685,61802,21344,34914}));
    }

    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int num = arr.length/20;
        int sum = 0;
        for (int i = num; i < arr.length - num; i++) {
            sum+=arr[i];
        }
        return sum/(0.9 * arr.length);
    }

    public double trimMean1(int[] arr) {
        int num = arr.length/20;
        int sum = 0;
        PriorityQueue<Integer> min = new PriorityQueue<>(num+1, Comparator.comparing(a -> -a));
        PriorityQueue<Integer> max = new PriorityQueue<>(num+1, Comparator.comparing(a -> a));
        for (int i = 0; i < num; i++) {
            min.offer(arr[i]);
        }
        for (int i = num; i < 2*num; i++) {
            min.offer(arr[i]);
            max.offer(min.poll());
        }
        for (int i = 2*num; i < arr.length; i++) {
            min.offer(arr[i]);
            max.offer(min.poll());
            sum+=max.poll();
        }
        return sum/(0.9 * arr.length);
    }
}
