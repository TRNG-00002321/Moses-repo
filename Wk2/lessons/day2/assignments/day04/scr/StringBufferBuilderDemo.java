// Write a program that demonstrates the use of StringBuffer and StringBuilder in Java.
public class StringBufferBuilderDemo {
    public static void main(String[] args){
        //
        StringBuffer str1 = new StringBuffer("string1");
        str1.append(" - StringBuffer");
        System.out.println("the StringBuffer st1 is : " + str1.toString());
        // insert method of StringBuffer
        str1.insert(0, "Hello ");
        System.out.println("Inserting at index 0 : " + str1.toString());

        StringBuilder str2 = new StringBuilder("string2");
        str2.append(" - StringBuilder");
        System.out.println("Using StringBuilder: " + str2.toString());




    }
}