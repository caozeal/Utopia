package com.caozeal.practice.function;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p>创建时间：2019/6/26 11:14
 * <p>com.writ.practice.function
 * @author caozhiyong
 * @version 1.0
 */
public class SupplierPractice {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Mal", "Wash", "Kaylee", "Inara",
                "Zoe", "Jayne", "Simon", "River", "Shepherd Book");
        Optional<String> first = names.stream()
                                      .filter(name -> name.startsWith("S"))
                                      .findFirst();
        System.out.println(first);
        System.out.println(first.orElse("None"));
        System.out.println(first.orElse(String.format("No result found in %s",
                names.stream().collect(Collectors.joining(", ")))));
        System.out.println(first.orElseGet(() ->
                String.format("No result found in %s",
                        names.stream().collect(Collectors.joining(", ")))));
    }
}
