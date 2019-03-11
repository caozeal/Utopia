package com.caozeal.practice.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>创建时间：2018/10/26 16:48
 * <p>com.caozeal.practice.lambda
 * @author caozhiyong
 * @version 1.0
 */
public class LambdaExp {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");
        List<String> sorted = strings.stream().sorted(String::compareTo).collect(Collectors.toList());
    }

}
