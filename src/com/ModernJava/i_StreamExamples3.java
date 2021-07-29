package com.ModernJava;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class i_StreamExamples3 {
    public static void main(String[] args) {
        System.out.println(
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
//                        .distinct() // 중복 제거 toset()을 쓰면 이문구 붎리요
//                        .collect(Collectors.joining(", ", "[", "]"))
//                        .collect(Collectors.toSet())
//                        .collect(Collectors.toList())

        );
        final Integer integer3 = 3;
        System.out.println(
                Stream.of(1,2,3,4,5)
                .filter(i -> i.equals(integer3))
                .findFirst()
        );
    }

}
