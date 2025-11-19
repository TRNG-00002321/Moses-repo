package com.raveture.lambda;

public class lambdaDemo {
    public static void main() {
        CalculateLambda addition = (a, b) -> a + b;
        CalculateLambda subtraction = (a, b) -> a - b;
        CalculateLambda multiplication = (a, b) -> a * b;
        CalculateLambda division = (a, b) -> a / b;

        int a = 20, b = 10;

        System.out.println("Addition: " + addition.operation(a, b));
        System.out.println("Subtraction: " + subtraction.operation(a, b));
        System.out.println("Multiplication: " + multiplication.operation(a, b));
        System.out.println("Division: " + division.operation(a, b));

        printResult(2,3, (x, y) -> x+y);
        printResult(a, b,(x,y)-> x-y);

    }
    public static void printResult(int a, int b, CalculateLambda func){
        // Perform operation print result
        int result = func.operation(a,b);
        System.out.println(result);
    }
}
