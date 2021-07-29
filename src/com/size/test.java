package com.size;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class test {
    public static void main(String[] args) {
        List<Integer> list = List.of(3,1,6,2);
        Stream<Integer> strm = list.stream();

        strm.map(x -> x*10).forEach(e -> System.out.print(e + ", "));
        System.out.println();
        list.stream().sorted().forEach(e -> System.out.print(e + ", "));
        System.out.println();
        list.stream().filter(x -> x > 2).forEach(e -> System.out.print(e + ", "));
        System.out.println();
        list.stream().findFirst().ifPresent(e -> System.out.print(e + ", "));
        System.out.println();
        list.stream().peek(e -> System.out.print(e + ", ")).limit(3).count();
    }
}
