package com.raveture.StreamAPI;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMain {
    public static void main(String[] args){

        List<Employee> employees= new ArrayList<Employee>();
        employees.add(new Employee("John", 50000, "IT"));
        employees.add(new Employee("Jane", 60000, "Finance"));
        employees.add(new Employee("Alice", 70000, "HR"));
        employees.add(new Employee("Bob", 80000, "IT"));
        employees.add(new Employee("Charlie", 90000, "Finance"));

        for (Employee emp : employees) {
            System.out.println(emp);
        }

        for(int i=0; i<employees.size(); i++){
            System.out.println(employees.get(i));
        }

        // print employees names in uppercase using the map function of Stream API
        employees.stream()
                .map(emp -> emp.getName().toUpperCase())
                .forEach(System.out::println);

        // Using Stream API to filter employees with salary greater than 60000
        employees.stream()
                .filter(emp -> emp.getAge() > 60000)
                .forEach(System.out::println);

    }
}
