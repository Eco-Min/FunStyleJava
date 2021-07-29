package com.ModernJava;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class k_StreamExamples5Parallel {
    public static void main(String[] args) {
        /*Anonymous Class 의 경우 class 외부의 variable에 접근하기위해서는
        그 variable 이 final variable 이어야만 합니다
        array의 경우 array 자체가 object이고 그 안의 값 변경은 array object의 상태변경이라 생각하면됨*/

        final int[] non_parallel_sum = {0};
        IntStream.range(0, 100)
                .forEach(i -> non_parallel_sum[0] += i);
        System.out.println("sum " + non_parallel_sum[0]);

        final int[] parallel_sum = {0};
        IntStream.range(0, 100)
                .parallel() //이럴경우 자동으로 parallel 프로그램으로 변경
                .forEach(i -> parallel_sum[0] += i);

        System.out.println("parallel sum (with side-effect) " + parallel_sum[0]);

        System.out.println("stream sum (no side-effect) " +
                IntStream.range(0, 100)
                        .sum());

        System.out.println("parallel stream sum (no side-effect) " +
                IntStream.range(0, 100)
                        .parallel()
                        .sum());

        System.out.println("================================================================");
        // parallel 같은경우 코어를 나눠서 하기때문에 순번은 막나오지만 처리소도가 빨리짐
       /* System.out.println("\nNone parallel Stream");
        final long start = System.currentTimeMillis();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)
                .stream()
                .map(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i;
                })
                .forEach(System.out::println);
        System.out.println(System.currentTimeMillis() - start);*/

        System.out.println("\nParallel Stream");
        final long start2 = System.currentTimeMillis();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)
                .parallelStream()
                .map(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i;
                })
                .forEach(System.out::println);
        System.out.println(System.currentTimeMillis() - start2);

        System.out.println("\nParallel Stream (9 elements)");
        final long start3 = System.currentTimeMillis();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8,9 )
                .parallelStream()
                .map(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i;
                })
                .forEach(System.out::println);
        System.out.println(System.currentTimeMillis() - start3);

        System.out.println("\nParallel Stream (8 elements)");
        System.setProperty("java.util.concurrentForkJoinPool.comon.parallelism", "7");
        // 코어 지정으로 돌리는것 0 = 1, 1 = 2, 3 = 4, 7 = 8
        final long start4 = System.currentTimeMillis();
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)
                .parallelStream()
                .map(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i;
                })
                .forEach(System.out::println);
        System.out.println(System.currentTimeMillis() - start4);
    }
}
