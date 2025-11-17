//Write a program –declare two variables a and b and initialize them to true and false respectively. Get the output of the following computations:
//        !a
//a | b
//        (!a & b) | (a & !b)

package com.raveture.assignemt;
public class LogicalOps2 {
    public void logicalOperations() {
        boolean a = true;
        boolean b = false;
        System.out.println("!a: " + !a);
        System.out.println("a | b: " + (a | b));
        System.out.println("(!a & b) | (a & !b): " + ((!a & b) | (a & !b)));
    }
    public static void main(String[] args) {
        LogicalOps2 logicOps = new LogicalOps2();
        logicOps.logicalOperations();
    }
}