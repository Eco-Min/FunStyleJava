package com.asm.ModernJava;

@FunctionalInterface
public interface funcPrac {
    Integer sumInt(int int1, int int2);

    default void println(String ss) {
        System.out.println("ss = " + ss);
    }
}
