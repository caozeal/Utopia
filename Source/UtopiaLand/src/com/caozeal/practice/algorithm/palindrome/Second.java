package com.caozeal.practice.algorithm.palindrome;

import org.apache.commons.lang.StringUtils;

/**
 * 改进：
 * 1. 二进制为回文数的话肯定是奇数
 * 2. 使用字符串逆转比较简单一些
 * 3. 多次测试，性能貌似下降了
 * 4. 数字变大的话，比如586之上最小的回文数，性能比第一种要提高许多
 * <p>创建时间：2018/7/23 16:46
 * <p>com.writ.practice.algorithm.palindrome
 * @author caozhiyong
 * @version 1.0
 */
public class Second {

    private static int getMinPalindromeUponX(int x){
        if(x % 2 == 0){
            x++;
        }
        while (true){
            String decNum = Integer.toString(x);
            String binNum = Integer.toBinaryString(x);
            String octNum = Integer.toOctalString(x);
            if(isPalindrome(decNum) && isPalindrome(binNum) && isPalindrome(octNum)) {
                return x;
            }
            x = x+2;
        }
    }

    private static boolean isPalindrome(String num){
        return StringUtils.equals(num, StringUtils.reverse(num));
    }

    public static void main(String[] args) {
        long ms = System.currentTimeMillis();
        int minPalindrome = getMinPalindromeUponX(586);
        long conMs = System.currentTimeMillis() - ms;
        System.out.println("minPalindrome = [" + minPalindrome + "], 耗时 = [" + conMs + "]");
    }
}
