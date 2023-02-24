package com.caozeal.leetcode.before20230224;

public class MySqrt {

    public static void main(String[] args) {
        MySqrt s = new MySqrt();
        System.out.println(s.mySqrt(313144444));
    }

    public int mySqrt(int x) {
        return compare(0, Math.min(x, (1 << 16)), x);
    }

    private int compare(int start, int end, int x){
        int mid = (end + start)/2;
        int floor = mid * mid;
        int top = (mid+1)*(mid+1);
        if(floor > x || floor < 0){
            return compare(start, mid, x);
        }
        if(top < x && top > 0){
            return compare(mid, end, x);
        }
        if(top == x){
            return mid+1;
        }
        return mid;
    }
}
