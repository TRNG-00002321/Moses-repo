/ Create a string assign the value " Hello World! " to demostrate various String methods
public class StringDemo01 {
    public static void main(String[] args) {
        String str = " Hello World! ";
        // 1. length() method
        System.out.println("Length: " + str.length());
        // 2. trim() method to remove spaces
        System.out.println("Trimed String: " + str.trim());
        // 3. toUpperCase: method to covert all sting characters to upper cases
        System.out.println("Upper Case version: " + str.toUpperCase());
        // 4. CharAt(): method to return the index character
        System.out.println(" Character at index 3 is: " + str.charAt(3));
        // 5. replace(): method to replace a character with another character
        System.out.println(" Replacing 'o' with 'a': " + str.replace('o', 'a'));
        // 6. concat(): method to concatenate two strings
        String str2 = " Welcome to Java Programming.";
        System.out.println(" Concatenated String: " + str.concat(str2));
        // 7. equals(): method to compare two strings
        String str3 = " Hello World! ";
        System.out.println(" Are str and str3 equal? " + str.equals(str3));
        // 8. equalsIgnoreCase(): method to compare two strings ignoring case differences
        String str4 = " hello world! ";
        System.out.println(" Are str and str4 equal (ignoring case)? " + str.equalsIgnoreCase(str4));
    }





