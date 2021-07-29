package com.ModernJava;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/*
First Class Function 조건
1. function()  <- 괄호안에 function을 넘기는것
2. {} function(parameter) <- {} 를 결과값이라 했을경우 function이 {} 결과값에 return 될 경우
3. F f = function or List<F> fs = Araays.asList(function) 식으로 or list.add(function)

 */
public class q_MethodReference {
    public static void main(String[] args) {
        MethodReference03();
    }

    //    First Class Function
    private static void MethodReference03() {
        /*
         * Function can be passed as a parameter to another function.
         */
//        Using Lambda Expression
        System.out.println(testFirstClassFunction(3, i -> String.valueOf(i * 2)));
//        Using Method Reference
        //static member method 인경우 본Class 를 꼭 적어줘야함
        System.out.println(testFirstClassFunction(3, q_MethodReference::doubleThenToString));

        /*
         * Function can be return as the result of another function
         */
//        Using Lambda Expression
        final Function<Integer, String> fl = getDoubleThenToStringUsingLambdaExpression();
        final String resultFromFl = fl.apply(3);
        System.out.println(resultFromFl);
//        Using Method Reference
        final Function<Integer, String> fmr = getdoubleThenTOStringUsingMethodReference();
        final String resultFromFmr = fmr.apply(3);
        System.out.println(resultFromFmr);

        /*
         * A function can be stored in the data structure.
         */
        // Using lambda Expression
        final List<Function<Integer, String>> fsl = Arrays.asList(i -> String.valueOf(i * 2));
        for (final Function<Integer, String> f : fsl) {
            final String result = f.apply(3);
            System.out.println(result);
        }
        // Using Method Reference
        final List<Function<Integer, String>> fsMr = Arrays.asList(q_MethodReference::doubleThenToString);
        for (final Function<Integer, String> f : fsMr) {
            final String result = f.apply(3);
            System.out.println(result);
        }

        /*
         * Using Lambda Expression
         */
        final Function<Integer, String> fl2 = i -> String.valueOf(i * 2);
        final String resultFl2 = fl2.apply(3);
        System.out.println(resultFl2);
        /*
         * Using Method Reference
         */
        final Function<Integer, String> fmr2 = q_MethodReference::doubleThenToString;
        final String resultFmr2 = fmr2.apply(3);
        System.out.println(resultFmr2);

        /*
        * Both Lambda Expression and Method Reference
         */
        List<Function<Integer, String>> fsBoth = Arrays.asList(
                i -> String.valueOf(i*2),
                q_MethodReference::doubleThenToString,
                q_MethodReference::addHashPrefix);

        for (final Function<Integer, String> f :
                fsBoth) {
            final String result = f.apply(3);
            System.out.println(result);
        }
    }

    private static String doubleThenToString(int n) {
        return String.valueOf(n * 2);
    }

    private static String testFirstClassFunction(int n, Function<Integer, String> f) {
        return "the result is " + f.apply(n);
    }

    private static Function<Integer, String> getDoubleThenToStringUsingLambdaExpression() {
        return i -> String.valueOf(i * 2);
    }

    private static Function<Integer, String> getdoubleThenTOStringUsingMethodReference() {
        return q_MethodReference::doubleThenToString;
    }

    private static String addHashPrefix(int number){
        return "#" + number;
    }
}
