package com.asm;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickStream {
    static List<Integer> quicksort(List<Integer> list) {
        if (list.size() < 2) {
            return list;
        }
        Integer pivot = list.remove(0);
        List<Integer> less;
        List<Integer> mor;

        less = list.stream().filter(n -> n <= pivot).collect(Collectors.toList());
        mor = list.stream().filter(n -> n >= pivot).collect(Collectors.toList());

        less = quicksort(less);
        mor = quicksort(mor);

        less.add(pivot);
        Stream<Integer> cob = Stream.concat(less.stream(), mor.stream());
        return cob.collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> a = Stream.of(2, 4, 7, 3, 6, 9, 5, 1, 0).collect(Collectors.toList());
        List<Integer> integers = quicksort(a);
        System.out.println(integers);
    }
}
