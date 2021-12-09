package com.asm.ModernJava;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class d_CustomFuctionalInterfaceExamples {
    public static void main(String[] args) {
//         void print(int i) //-> 쓰기전
        println("area is", 12, 20, (message, length, width) -> "hello " + message + (length * width));
        println(1, 2, 3, (i1, i2, i3) -> String.valueOf(i1 + i2 + i3));
        println(1L, "Kevin", "Test@email.com",
                (id, name, email) -> "user info: ID=" + id + ", name=" + name + ", email=" + email);

        BigDecimalToCurrency bigDecimalToCurrency = bd -> "$" + bd.toString();
        System.out.println(bigDecimalToCurrency.toCurrency(new BigDecimal("120.00")));
        final InvaliedFunctionalInterface invaliedFunctionalInterface = new InvaliedFunctionalInterface() {
            @Override
            public <T> String mkString(T value) {
                return value.toString();
            }
        };
        System.out.println("anonymous class : " + invaliedFunctionalInterface.mkString(123));
//        final InvaliedFunctionalInterface functionalInterface = it -> it.toString(); -> functional programing 이 될 수 없다.
        System.out.println("anonymous class : " + invaliedFunctionalInterface.mkString(123));

        List<Object> hello = myFunc(10, 11, 12, (i1, i2, i3) -> String.valueOf(i1 + i2 + i3));
        System.out.println("hello : " + hello);

    }

    private static <T1, T2, T3> void println(T1 t1, T2 t2, T3 t3, Function3<T1, T2, T3, String> function) {
        System.out.println(function.apply(t1, t2, t3));
    }

    private static <T1, T2, T3, R> List<R> myFunc(T1 t1, T2 t2, T3 t3, MyFunc<T1, T2, T3, String> func) {
        List<R> result = new ArrayList<>();
        String apply = func.apply(t1, t2, t3);
        result.add((R) apply);
        return result;
    }
}

// 람다식 즉 abstract -> @FunctionalInterface 를 쓰면 무조건 하나만 답이 들어 가야한다
//@FunctionalInterface
interface Function3<T1, T2, T3, R> {
    R apply(T1 t1, T2 t2, T3 t3);
}

interface MyFunc<T1, T2, T3, R> {
    R apply(T1 t1, T2 t2, T3 t3);
}

@FunctionalInterface
interface BigDecimalToCurrency {
    String toCurrency(BigDecimal value);
}

@FunctionalInterface
interface InvaliedFunctionalInterface {
    <T> String mkString(T value);
}
