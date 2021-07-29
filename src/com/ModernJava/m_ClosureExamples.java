package com.ModernJava;

public class m_ClosureExamples {
    int number = 100;

    public static void main(String[] args) {
//       /* int number = 100;
//        System.out.println("Anonymous Class");
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(number);
//            }
//        };
//        runnable.run();
//
//        System.out.println("Lambda");
//        Runnable runnable2 = () -> System.out.println(number);
//        runnable2.run();
//
//        System.out.println("testClousre");
//        testClosure("anonymous Class", new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(number);
//            }
//        });
//        testClosure("Lambda Expression", () -> System.out.println(number));
//        //raceCondition "두 thread 가 한 값을 가지고 싸우는것" -> runnable을 사용하려면 final or effective fianl 로 써야 가능
//
        System.out.println("testClousre1 ***********************");
        new m_ClosureExamples().test1();
        System.out.println("testClousre2 ***********************");
        new m_ClosureExamples().test2();
        System.out.println("testClousre3 ***********************");
        new m_ClosureExamples().test3();
        System.out.println("testClousre4 ***********************");
        new m_ClosureExamples().test4();
    }

    @Override
    public String toString() {
        return new StringBuilder("Closure Examples{").
                append("number=")
                .append(number)
                .append("}")
                .toString();
    }

    public static <T> String toString(T value) {
        return "the value is " + String.valueOf(value);
    }

    private void test1() {
        int number = 100;
        testClosure("Anonymous Class", new Runnable() {
            @Override
            public void run() {
                System.out.println(number);
               /*  ex> test1 안에 number가 선언x
               this 를 쓰고싶다 -> 그냥 this 쓰면 안됨 -> 현class 이름과 같이 써야함
               ex> n_ClousreExamples.this.number
               */
            }
        });

        testClosure("Lambda Expression", () -> System.out.println(number));
        /* this 는 써도 에러가 안남 -> Lambda Expression 에 대한 자체 scope 이 없다.
        -> ClousreExamples 로 접근 즉, Lambda 안에 this는 호출 불가 */
    }

    private void test2() {
        testClosure("this.tostring()", new Runnable() {
            @Override
            public void run() {
                System.out.println(this.toString());
            }
        });

        testClosure("n_ClosureExamples.this.tostring()", new Runnable() {
            @Override
            public void run() {
                System.out.println(m_ClosureExamples.this.toString());
            }
        });

        testClosure("Lambda Expression", () -> System.out.println("this.tostrin() : " + this.toString()));

    }

    private void test3() {
        testClosure("Anonymous Class tostring", new Runnable() {
            @Override
            public void run() {
                System.out.println(m_ClosureExamples.this.toString("hello"));
//                System.out.println(toString("Test"));
                /*위상황처럼 하면 오류가 난다
                -> anonymous calss 가 가지고있는 메소드와 이름이 동일한 외부 메소드에 접금한 경우 shadowing이 발생*/
            }
        });

        testClosure("Lambda Expression", () -> System.out.println("this.tostrin() : " + toString("Test")));

    }

    private void test4() {
        int number = 100;
        testClosure("Anonymous Class", new Runnable() {
            @Override
            public void run() {
                int number = 50;
                System.out.println(m_ClosureExamples.this.number);
                // shadowing 이 일어난다
                System.out.println(number);
            }
        });

        testClosure("Lambda Expression", () -> System.out.println(this.number));
        /*testClosure("Lambda Expression", () -> {
            int number = 50;
            System.out.println(number);
        });
        Lambda expression 은 scope이 없다 그래서 외부로 확장이 된다*/
    }


    private static void testClosure(final String name, final Runnable runnable) {
        System.out.println("============================================");
        System.out.println("Start" + name + " : ");
        runnable.run();

    }
}
