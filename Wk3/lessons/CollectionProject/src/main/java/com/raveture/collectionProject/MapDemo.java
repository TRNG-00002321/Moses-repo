package com.raveture.collectionProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main() {
        // A map using the HashMap implementation
        Map<String, Double> persons = new HashMap<String, Double>();
        persons.put("Moses", 8005.00);
        persons.put("Saah", 90000.00);
        persons.put("Tamba", 200000.00);

        // Retrieviing value using the key. Duplicate keys will return the latest value
        System.out.println(persons.get("Tamba"));

        // Iteratin a map
        Set<String> names = persons.keySet();
        // Using the KeySet utility functon

        // Set names1 = persons.keySet();
        for (String name:names){
            System.out.println(name + ", " + persons.get(name));
        }


    }
}
