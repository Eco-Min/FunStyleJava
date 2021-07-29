package com.Stream;

import java.util.stream.*;

public class Reduce {
    public static void main(String[] args) {
        Integer sum = Stream.of(1,2,3,4)
                .reduce(-1, (a,b) -> a+b);

        System.out.println(sum);
    }
}
