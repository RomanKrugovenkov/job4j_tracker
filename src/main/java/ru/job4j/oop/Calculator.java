package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int b) {
        return b - x;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int rSum = sum(10);
        System.out.println(rSum);
        int rMult = calculator.multiply(5);
        System.out.println(rMult);
        int rMin = minus(3);
        System.out.println(rMin);
        int rDiv = calculator.divide(12);
        System.out.println(rDiv);
        System.out.println(calculator.sumAllOperation(4));
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int c) {
        return c / x;
    }

    public int sumAllOperation(int z) {
        return sum(z) + multiply(z) + minus(z) + divide(z);
    }
}
