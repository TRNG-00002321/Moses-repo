import java.util.Scanner;
public class ScannerDemo{
    public static void main(String[] args){
    String firstName;
    Scanner scanner = new Scanner(System.in);
    System.out.printIn("Enter your Name: ");
    firstName = scanner.next();
    System.out.printIn("Hello, " + firstName);
    }
}