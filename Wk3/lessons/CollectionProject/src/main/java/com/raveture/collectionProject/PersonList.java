package com.raveture.collectionProject;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class PersonList {
    public static void main(String[] args){
        Person person1 = new Person("Moses","01", 24 );
        Person person2 = new Person("Saah","02", 25 );

        List<Person> personCollection = new ArrayList<Person>();
        personCollection.add(person1);
        personCollection.add(person2);



    }

}

