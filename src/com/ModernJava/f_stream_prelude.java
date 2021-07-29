package com.ModernJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class f_stream_prelude {
    public static void main(String[] args) {
        final int abs1 = Math.abs(-1);
        final int abs2 = Math.abs(1);
        System.out.println("abs1 == abs2 is" + (abs1 == abs2));

        final int minInt = Math.abs(Integer.MIN_VALUE);
        final int maxInt = Math.abs(Integer.MAX_VALUE);
        System.out.println("minInt : " + minInt);
        System.out.println("maxInt : " + maxInt);
        System.out.println();

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("mapOld : " + (mapOld(numbers, i -> i * 2)));
        System.out.println("mapOld : " + mapOld(numbers, null));
        System.out.println("map : " + (map(numbers, i -> i * 2)));
        System.out.println("map : " + map(numbers, Function.identity()));
//        System.out.println("map : " + map(numbers, null));
    }

    private static <T, R> List<R> map(final List<T> list, final Function<T, R> mapper) {
        final List<R> result = new ArrayList<>();
        for (final T t:list) {
            result.add(mapper.apply(t));
        }
        return result;
        /*final Function<T, R> function;
        if (mapper != null) {
            function = mapper;
        } else {
            function = x -> (R) x;
        }
        final List<R> result = new ArrayList<>();
        for (final T t : list) {
            result.add(function.apply(t));
        }
        return result;*/
    }

    private static <T, R> List<R> mapOld(final List<T> list, final Function<T, R> mapper) {
        final List<R> result = new ArrayList<>();
        /*final List<R> result;
        if (mapper != null) {
            result = new ArrayList<>();
        } else {
            result = new ArrayList<>((List<R>) list);
        }*/
        if (result.isEmpty()) {
            for (final T t : list) {
                if (mapper != null) {
                    result.add(mapper.apply(t));
                } else {
                    result.add((R) t);
                }
            }
        }
        return result;
    }
}
