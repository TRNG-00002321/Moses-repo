/*11/12 Java Assignments Set 1:



4) Using for loops, print a * staircase such that the nth line has n stars. You can also do a backwards staircase afterwards for symmetry.

 */

public class Assignment.java{

    public static void main(String[] args){

        // 2) Using if else logic statements, return the greater of 3 numeric inputs
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        int num3 = Integer.parseInt(args[2]);

        if (num1 >= num2 && num1 >= num3){
            System.out.println("The max number is: " + num1);
        } else if (num2 >= num1 && num2 >= num3) {
            System.out.println("The max number is: " + num3);
        } else {
            System.out.println("The max number is: " + num3);
        }
    }
}