package com.raveture.collectionProject;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ArrayListImplementation {
    public static void main(String[] args){
        ArrayList<String> my_names = new ArrayList<>();
        my_names.add("Peter");
        my_names.add("Henry");
        my_names.add("Jesus");
        my_names.add("Moses");

        Iterator iterator = my_names.iterator();

        if (my_names.isEmpty()){
            System.out.println("The list is Empty");
        }

        for (int i = 0; i<my_names.size(); i++){
            System.out.println(my_names.get(i));
        }

        // Contains method
        if (my_names.contains("Jesus")){
            System.out.println("The list contains Jesus");
        }
        // Remove method
        my_names.remove("Henry");
        System.out.println("After removing Henry:");
        for (String name : my_names) {
            System.out.println(name);
        }

        // equals method
        ArrayList<String> another_list = new ArrayList<>();
        another_list.add("Peter");
        another_list.add("Jesus");
        another_list.add("Moses");
        if (my_names.equals(another_list)){
            System.out.println("Both lists are equal");
        } else {
            System.out.println("Both lists are not equal");
        }
    }
}
