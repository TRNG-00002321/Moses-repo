package com.raveture.collectionProject;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
public class ListDemo {
    public static void main(String[] args) {
        // Create a List to hold String elements
        List myList = new ArrayList();
        myList.add(1);
        myList.add("Hello");
        myList.add(3.14);

        System.out.println(myList.get(1));
        // Iterate through the List and print each element
        Iterator iterator = myList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

            // for loop iteration
            for (int i = 0; i < myList.size(); i++) {
                System.out.println(myList.get(i));
            }

            // Enhanced for loop iteration
            for (Object element : myList) {
                System.out.println(element);
            }

            // Specify Object type
            List<String> stringList = new ArrayList<>();
            stringList.add("Apple");
            stringList.add("Banana");
            stringList.add("Cherry");
            for (String fruit : stringList) {
                System.out.println(fruit);
            }

        }
    }
}
