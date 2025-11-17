// The other class should contain only the main() method which calls each of
// the methods from the previous class.
package com.raveture.assignemt;
public class ProgramDriver {
    public static void main  (String[] args){
        // Create an instance of Operations class
        Operations ops = new Operations();
        // Test the methods
        int num1 = 10;
        int num2 = 2;
        System.out.println("Addition: "+ ops.add(num1, num2));
        System.out.println("Subtraction: "+ ops.subtract(num1, num2));
        System.out.println("Multiplication: "+ ops.multiply(num1, num2));
        System.out.println("Division: "+ ops.divide(num1, num2));
    }
}