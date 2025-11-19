package com.raveture.lambda;

import java.util.Optional;

public class PersonMain {
    public static void main(String[] args) {

        // A main class create two person objects, one with an address and another without and address
        // check the nullability: something that has to do with Optional
        Address address1 = new Address("202 Lofa St", "Monvoria", "62701");
        Person person1 = new Person("Peter Harris", address1, 1234567890);
        Person person2 = new Person("Ian Smith", null, 987654321);
        Optional checkNull = Optional.ofNullable(person2.getAddress());
        if (checkNull.isPresent()) {
            System.out.println("Person 2 Address: " + person2.getAddress());
        } else {
            System.out.println("Person 2 Address is null");
        }
        System.out.println(person1.toString());
        System.out.println(person2.toString());





    }
}
