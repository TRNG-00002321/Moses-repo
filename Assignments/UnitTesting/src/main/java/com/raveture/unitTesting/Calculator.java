package com.raveture.unitTesting;

public class Calculator {
    // Add methods for add, subtract, multiply, divide, isEven, isPositive

    // Method to add two integers: two parameters, return their sum
    public int addition(int a, int b){
        return a+b;
    }

    // Method to subtract two integers: two parameters, return their difference
    public int subtract(int a, int b){
        return a - b;
    }
    // Method to multiply two integers: two parameters, return their product
    public int multiply(int a, int b){
        return a*b;
    }

    // Method to divide two integers: two parameters, return their quotient
    public int divide(int a, int b){
        // Handle division by zero
        if (b == 0){
            // Throw an exception if b is zero. ArithmeticException is a built-in exception in Java
            throw new ArithmeticException("Can't divide by Zero");

        }
        return a / b;
    }

    // Method to check if an integer is even: one parameter, return true if even, false otherwise
    public boolean isEven(int n){
        return n % 2==0;
    }

    // Method to check if an integer is positive: one parameter, return true if positive, false otherwise
    public boolean isPositive (int n){
       return n >0;
    }

}
