//Write a program to add, subtract, multiply and divide two non zero hard-coded numbers.
//Write a program to search for the greatest of three numbers using Short-circuit Operators and print the result.


package com.raveture.assignemt;
public class LogicalOps {
    // Method to add two numbers
    public int add(int a, int b) {
        return a + b;
    }

    // Method to subtract two numbers
    public int subtract(int a, int b) {
        return a - b;
    }

    // Method to multiply two numbers
    public int multiply(int a, int b) {
        return a * b;
    }

    // Method to divide two numbers
    public double divide(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Division by zero");
            return 0;
        }
        return (double) a / b;
    }
}
