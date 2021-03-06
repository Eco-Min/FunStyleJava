package com.asm.ModernJava;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class g_StreamExamples1 {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10).forEach(i -> System.out.print(i + " "));
        IntStream.iterate(1, i-> i+1).forEach(i -> System.out.print(i+ " "));
/*
        IntStream.iterate(BigInteger.ONE,
                i -> i.add(BigInteger.ONE)).forEach(i -> System.out.print(i+ " "));
*/
    }
}
