package com.ModernJava;

public class b_OopAndFP {
    public static void main(String[] args) throws IllegalAccessException {
      /*  //1
        final CallatorService callatorService = new CallatorService();
        final int addResult = callatorService.calculate('+', 1, 1);
        System.out.println(addResult);
        final int subResult = callatorService.calculate('-', 1, 1);
        System.out.println(subResult);
        final int mulResult = callatorService.calculate('*', 1, 1);
        System.out.println(mulResult);
        final int divResult = callatorService.calculate('/', 9, 3);
        System.out.println(divResult);*/

        final CalcuatorService calcuatorService1 = new CalcuatorService(new Add());
        final int addResult = calcuatorService1.calculate(11, 4);
        System.out.println(addResult);

        final CalcuatorService calcuatorService2 = new CalcuatorService(new Sub());
        final int subResult = calcuatorService2.calculate(11, 1);
        System.out.println(subResult);

        final CalcuatorService calcuatorService3 = new CalcuatorService(new Mul());
        final int mulResult = calcuatorService3.calculate(11, 2);
        System.out.println(mulResult);

        final CalcuatorService calcuatorService4 = new CalcuatorService(new Div());
        final int divResult = calcuatorService4.calculate(20, 4);
        System.out.println(divResult);

        final FpCalculatorService fpCalculatorService = new FpCalculatorService();
        System.out.println(fpCalculatorService.calculate(new Add(), 11, 4));
        System.out.println(fpCalculatorService.calculate(new Sub(), 11, 1));
        System.out.println(fpCalculatorService.calculate(new Mul(), 11, 2));
        System.out.println(fpCalculatorService.calculate(new Div(), 20, 4));

        final FpCalculatorService fpCalculatorService2 = new FpCalculatorService();
        System.out.println(fpCalculatorService2.calculate((i1, i2) -> i1 + i2, 11, 4));
        System.out.println(fpCalculatorService2.calculate((i1, i2) -> i1 - i2, 11, 1));
        System.out.println(fpCalculatorService2.calculate((i1, i2) -> i1 * i2, 11, 2));
        System.out.println(fpCalculatorService2.calculate((i1, i2) -> i1 / i2, 20, 4));
    }
}

/*//1
class CallatorService {
    public int calculate(char calculation, int num1, int num2) throws IllegalAccessException {
        if (calculation == '+')
            return num1 + num2;
        else if (calculation == '-')
            return num1 - num2;
        else if (calculation == '*')
            return num1 * num2;
        else if (calculation == '/')
            return num1 / num2;
        else
            throw new IllegalAccessException("Unknown calculation: " + calculation);
    }
}*/

interface Calculation {
    int calculate(int num1, int num2);
}

class Add implements Calculation {

    @Override
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }
}

class Sub implements Calculation {

    @Override
    public int calculate(int num1, int num2) {
        return num1 - num2;
    }
}

class Mul implements Calculation {

    @Override
    public int calculate(int num1, int num2) {
        return num1 * num2;
    }
}

class Div implements Calculation {

    @Override
    public int calculate(int num1, int num2) {
        return num1 / num2;
    }
}

class CalcuatorService {
    private final Calculation calculation;

    public CalcuatorService(final Calculation calculation) {
        this.calculation = calculation;
    }

    public int calculate(int num1, int num2) throws IllegalAccessException {
        if (num1 > 10 && num2 < num1)
            return calculation.calculate(num1, num2);
        else
            throw new IllegalAccessException("Invalid input num1: " + num1 + ", " + "num2: " + num2);
    }
}

class FpCalculatorService {
    public int calculate(Calculation calculation, int num1, int num2) throws IllegalAccessException {
        if (num1 > 10 && num2 < num1) {
            return calculation.calculate(num1, num2);
        } else {
            throw new IllegalAccessException("Invalid input num1: " + num1 + ", " + "num2: " + num2);
        }
    }
}

