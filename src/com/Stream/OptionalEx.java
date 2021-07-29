package com.Stream;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalEx {
    public static void main(String[] args) {
        Optional<Integer> i = Optional.empty();
        Optional<Boolean> b = Optional.empty();
        Optional<Optional<Integer>> ii = Optional.empty();
        Optional<Integer> on = Optional.of(10);
        System.out.println(on.get()+10);
        on.map(x -> x*3);

        List<Integer> list = List.of(1,2,3);
        list.stream().map(x -> x*3).collect(Collectors.toList());

    }
}
