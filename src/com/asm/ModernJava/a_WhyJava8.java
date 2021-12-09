package com.asm.ModernJava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class a_WhyJava8 {
    public static void main(String[] args) {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        final StringBuilder stringBuilder = new StringBuilder();
        for (Integer number : numbers) {
            stringBuilder.append(number).append(" : ");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.delete(stringBuilder.length() - 3, stringBuilder.length());
        }
        System.out.println(stringBuilder.toString());

        final String result = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" : "));
        System.out.println(result);
    }

}
