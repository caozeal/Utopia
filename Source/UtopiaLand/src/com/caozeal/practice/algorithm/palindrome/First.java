package com.caozeal.practice.algorithm.palindrome;

/**
 * 1.更通用一些的方法
 * <p>创建时间：2018/7/23 15:44
 * <p>com.writ.practice.algorithm.palindrome
 * @author caozhiyong
 * @version 1.0
 */
public class First {

    private static int getMinPalindromeUponX(int x){
        for(int i=x; ;i++){
            if(isPalindrome(i, 10) && isPalindrome(i, 2) && isPalindrome(i, 8)) {
                return i;
            }
        }
    }

    private static boolean isPalindrome(int num, int scale){
        int[] arr = new int[200];
        int digit = 0;
        int originNum = num;
        int invetNum = 0;
        while (num != 0){
            arr[digit] = num % scale;
            num = num / scale;
            digit++;
        }
        digit--;
        for(int i=0; i<=digit; i++){
            invetNum = (int)(invetNum + (Math.pow(scale, i)) * arr[digit - i]);
        }
//        System.out.println("originNum = [" + originNum + "], invetNum = [" + invetNum + "], digit = [" + digit + "]");
        return invetNum == originNum;
    }

    public static void main(String[] args) {
        long ms = System.currentTimeMillis();
        int minPalindrome = getMinPalindromeUponX(586);
        long conMs = System.currentTimeMillis() - ms;
        System.out.println("minPalindrome = [" + minPalindrome + "], 耗时 = [" + conMs + "]");
    }
}
