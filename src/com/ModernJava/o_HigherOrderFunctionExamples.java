package com.ModernJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

// parameter, function이 또다른 function, parameter가 function을 return 이 모든걸다 HigherOrderFunction
public class o_HigherOrderFunctionExamples {
    public static void main(String[] args) {
        final Function<Function<Integer, String>, String> f = g -> g.apply(10);
        System.out.println(f.apply(i -> "#" + i));

        final Function<Integer, Function<Integer, Integer>> f2 = i -> i2 -> i + i2;
        System.out.println(f2.apply(1).apply(9));

        final List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(map(list, i -> "#" + i));
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        final List<R> result = new ArrayList<>();
        for (final T t : list) {
            result.add(mapper.apply(t));
        }
        return result;
    }
}
