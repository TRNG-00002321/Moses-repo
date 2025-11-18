package com.raveture.collectionProject;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        // HashSet will not maintain the order of insertion
        // Set<String> names=new HashSet<String>();
        // Set<String> names=new LinkedHashSet<String>();
        // TreeSet will maintain the order of insertion
        Set<String> names=new TreeSet<String>();

        names.add("Andrew");
        names.add("Ian");
        names.add("People");

        // Enhance For loop
        for (String n:names ){
            System.out.println(n);
        }

        // contains Method
        if (names.contains("Moses")){
            System.out.println("Yes");
        } else {
            System.out.println("No Idiot");
        }

    }
}
