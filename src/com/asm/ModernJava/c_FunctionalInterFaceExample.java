package com.asm.ModernJava;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class c_FunctionalInterFaceExample {
    public static void main(String[] args) {
        Function<String, Integer> toInt = new Function<String, Integer>() {
            @Override
            public Integer apply(String value) {
                return Integer.parseInt(value);
            }
        };

        final Integer number = toInt.apply("100");
        System.out.println(number);

        Function<String, Integer> ToInt = (values) -> Integer.parseInt(values);
        final Integer Number = ToInt.apply("100");
        System.out.println(Number);

        Function<Integer, Integer> function = t -> t;
        System.out.println(function.apply(999));

        final Consumer<String> print = (value) -> System.out.println("JJ + " + value);
        print.accept("hello");

        Predicate<Integer> isPositive = i -> i > 0;
        System.out.println(isPositive.test(1));
        System.out.println(isPositive.test(0));
        System.out.println(isPositive.test(-1));

        List<Integer> numbers = Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5);
        List<Integer> postiveNumbers = new ArrayList<>();
        for (Integer num : numbers) {
            if (isPositive.test(num))
                postiveNumbers.add(num);
        }
        System.out.println("postive integers : " + postiveNumbers);
        System.out.println("postive integers Filter method : " + filter(numbers, isPositive));

        //LazyEvaluation 이 필요하다 하면 이걸 쓰면됨
        final Supplier<String> helloSupplier = () -> "hello";

        System.out.println(helloSupplier.get() + "world");
//        printIfValidIndex(0, "Kevin");
//        printIfValidIndex(-1, "Kevin");
        long start = System.currentTimeMillis();
//        printIfValidIndex(0, getVeryExpensiveValue());
//        printIfValidIndex(-1, getVeryExpensiveValue());
//        printIfValidIndex(-2, getVeryExpensiveValue());
        printIfValidIndex(0, () -> getVeryExpensiveValue());
        printIfValidIndex(-1, () -> getVeryExpensiveValue());
        printIfValidIndex(-2, () -> getVeryExpensiveValue());
        System.out.println("It took" + ((System.currentTimeMillis() - start) / 1000) + " sec");
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> filter) {
        List<T> result = new ArrayList<>();
        for (T input : list) {
            if (filter.test(input))
                result.add(input);
        }
        return result;
    }

    /*private static void printIfValidIndex(int number, String value) {
        if (number >= 0) {
            System.out.println("the value is " + value + ".");
        } else {
            System.out.println("invalid");
        }
    }*/
    //Supplier 을 썻을경우
    private static void printIfValidIndex(int number, Supplier<String> valueSupplier) {
        if (number >= 0) {
            System.out.println("the value is " + valueSupplier.get() + ".");
        } else {
            System.out.println("invalid");
        }
    }

    private static String getVeryExpensiveValue() {
        //Let's just say it has very expensive calculation here!
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Kevin";
    }
}