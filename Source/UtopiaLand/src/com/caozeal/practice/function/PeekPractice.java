package com.caozeal.practice.function;

import java.util.stream.IntStream;

/**
 * <p>创建时间：2019/7/15 14:12
 * <p>com.writ.practice.function
 * @author caozhiyong
 * @version 1.0
 */
public class PeekPractice {

    public static void main(String[] args) {
        PeekPractice peekPractice = new PeekPractice();
        System.out.println(peekPractice.sumDoublesDivisibleBy3(100, 120));
    }

    private int sumDoublesDivisibleBy3(int start, int end) {
        return IntStream.rangeClosed(start, end)
                        .peek(n -> System.out.printf("original: %d%n", n))
                        .map(n -> n * 2)
                        .peek(n -> System.out.printf("doubled : %d%n", n))
                        .filter(n -> n % 3 == 0)
                        .peek(n -> System.out.printf("filtered: %d%n", n))
                        .sum();
    }
}
