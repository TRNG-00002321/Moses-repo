package com.raveture.collectionProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class SortDemo {
    public static void main() {
        List<String> names=new ArrayList<String>();
        names.add("Brain");
        names.add("Jay");
        names.add("Leila");
        names.add("Kumba");

        Collections.sort(names);
        System.out.println(names);
    }
}
