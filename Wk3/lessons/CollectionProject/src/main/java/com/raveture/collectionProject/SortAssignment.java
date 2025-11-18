package com.raveture.collectionProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class SortAssignment {
    public static void main() {
        // Instantiating from the Person class
        Person p1 = new Person("Moses","11", 24 );
        Person p2 = new Person("Saah","02", 25 );
        Person p3 = new Person("Alex","00", 24 );
        Person p4 = new Person("Gary","13", 35 );
        Person p5 = new Person("Amma","07", 21 );

        // persons added to a list
        List<Person> personList=new ArrayList<Person>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        personList.add(p5);
        for(Person p:personList){
            System.out.println(p);
        }

        // Display List Sorted by ID using the comparator
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getId().compareTo(p2.getId());
            }
        });
        System.out.println("Sorted by ID:");
        for(Person p:personList){
            System.out.println(p);
        }
        // Display List Sorted
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person ag1, Person ag2) {
                return ag1.getAge().compareTo(ag2.getAge());
            }
        });
        System.out.println("Sorted by Age");
        for(Person p:personList){
            System.out.println(p);
        }


        // Sorted by names
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person n1, Person n2){
                return n1.getName().compareTo(n2.getName());
            }

        });

        System.out.println("Sorted by Names");
        for(Person p:personList){
            System.out.println(p);
        }

    }
}
