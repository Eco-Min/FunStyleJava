package com.asm;

import java.util.Optional;

public class MonadAndOptional {
    static Optional<Integer> addOpt(Optional<Integer> x, Optional<Integer> y) {
        return x.flatMap(
                a -> y.flatMap(b -> Optional.of(a + b)));

    }

    public static void main(String[] args) {
        Optional<Integer> x = Optional.empty();
        Optional<Integer> result = addOpt(Optional.of(10), Optional.of(20));
        System.out.println(result);
        result = addOpt(Optional.empty(), Optional.of(20));
        System.out.println(result);
    }
}
