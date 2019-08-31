package com.caozeal.practice.function;

import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>创建时间：2019/7/15 13:51
 * <p>com.writ.practice.function
 * @author caozhiyong
 * @version 1.0
 */
public class ReducePractice {

    public static void main(String[] args) {
//        acc();
        sort();
    }

    private static void sort() {
        List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");
        List<String> sorted = strings.stream()
                                     .sorted(Comparator.comparingInt(String::length))
                                     .collect(Collectors.toList());
        sorted.stream()
              .reduce((prev, cur) -> {
                  Assert.isTrue(prev.length() <= cur.length(), "sorted未正确排序");
                  return cur;
              });
        strings.stream()
               .reduce((prev, cur) -> {
                   Assert.isTrue(prev.length() <= cur.length(), "strings未正确排序");
                   return cur;
               });
    }

    private static void acc() {
        BigDecimal total = Stream.iterate(BigDecimal.ONE, n -> n.add(BigDecimal.ONE))
                                 .limit(10)
                                 .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("The total is " + total);
    }
}
