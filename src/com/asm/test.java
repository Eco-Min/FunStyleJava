package com.asm;

import java.util.List;
import java.util.stream.Stream;

public class test {
    String name;
    Integer age;

    test(String name, Integer age) {
        this.age = age;
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    Integer getAge() {
        return this.age;
    }

    public String toString() {
        return "A{" + "name = " + name + " age = " + age + " }";
    }

    public static void main(String[] args) {
        List<test> list = List.of(new test("John", 10), new test("Ted", 14));
        list.stream().map(test::getAge).forEach(System.out::println);
        list.stream().map(test::getName).forEach(System.out::println);


    }
}
