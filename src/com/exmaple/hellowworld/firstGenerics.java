package com.exmaple.hellowworld;

/**
 * firstGenerics
 */
public class firstGenerics {
    public static void main(String[] args) {
        first first = new first();
        first.set("x", "y");
        System.out.println(first.get());
        first first1 = new first();
        first1.set(true, "a");
        System.out.println(first1.get());
        first first2 = new first();
        first2.set(4, "false");
        System.out.println(first2.get());

    }
}