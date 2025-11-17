/*Write a program to add, subtract, multiply and divide two numbers using methods with parameters using only one class.
In one project, create two classes. One class should contain only methods (add, subtract, multiply and divide). The other class should contain only the main() method which calls each of the methods from the previous class.
Create an example for each control statement/*

package packages;
 */
public class Operations {
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