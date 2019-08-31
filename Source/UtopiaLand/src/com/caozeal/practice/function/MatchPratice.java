package com.caozeal.practice.function;

import java.math.BigInteger;
import java.util.stream.IntStream;

/**
 * <p>创建时间：2019/7/18 11:06
 * <p>com.writ.practice.function
 * @author caozhiyong
 * @version 1.0
 */
public class MatchPratice {

    public static void main(String[] args) {
        System.out.println(isPrime(11));
        System.out.println(new BigInteger("11").isProbablePrime(1));
    }

    public static boolean isPrime(int num) {
        int limit = (int) (Math.sqrt(num) + 1);
        return num == 2 || num > 1 && IntStream.range(2, limit)
                                               .noneMatch(divisor -> num % divisor == 0);
    }
}
