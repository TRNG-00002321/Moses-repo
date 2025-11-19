package com.raveture.lambda;

public class LambdaMain {
    public static void main(String[] args) {
        // Lambda Function that as no parameters return value but prints Hello
        // LambdaInterface l1 = () -> System.out.println("Hello from Lambda!");
        // Lambda function takes 1 parameter and return Hello and argument in uppercase
        // LambdaInterface l2 = (a) -> System.out.println("Hello from Lambda!"+ a.toUpperCase());
        // Lambda function: two parameters and return "Hello + arg1 and arg2
        LambdaInterface l3 =(a, b) -> "Hello "+ a +" " + b;

        // Method calls
        //l1.display();
        //l2.one_arg_print("moses");
        System.out.println(l3.two_arg_print("Moses", "Saah"));






    }
}
