package com.asm.ModernJava;

import java.math.BigDecimal;
import java.util.Arrays;

import static java.util.stream.Collectors.toList;

public class p_MethodReferenceExamples {
    public static void main(String[] args) {
        Arrays.asList(1, 2, 3, 4, 5)
                .forEach(System.out::println);

        System.out.println(
                Arrays.asList(new BigDecimal("10.0"), new BigDecimal("23"), new BigDecimal("5"))
                        .stream()
//                        .sorted((bd1, bd2) -> bd1.compareTo(bd2))
//                        .sorted(BigDecimal::compareTo)
                        .sorted(BigDecimalUtil::compare)
//                        static method 를 넘기는 방법
                        .collect(toList())
        );

        System.out.println(
                Arrays.asList("a", "b", "c", "d")
                        .stream()
                        .anyMatch(s -> s.equals("c"))
        );

        final String targetString = "c";
        System.out.println(
                Arrays.asList("a", "b", "c", "d")
                        .stream()
                        .anyMatch(targetString::equals)
        );
    }
}

class BigDecimalUtil {
    public static int compare(BigDecimal bd1, BigDecimal bd2) {
        return bd1.compareTo(bd2);
    }
}