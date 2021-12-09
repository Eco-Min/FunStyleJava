package com.asm;

import java.util.List;

public class Test {
    String name;
    Integer age;

    Test(String name, Integer age) {
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
        List<Test> list = List.of(new Test("John", 10), new Test("Ted", 14));
        list.stream().map(Test::getAge).forEach(System.out::println);
        list.stream().map(Test::getName).forEach(System.out::println);
    }
}
