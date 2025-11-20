package com.raveture.StreamAPI;

public class Employee {
    private String name;
    private int salary;
    private String department;

    public Employee(String name, int age, String department) {
        this.name = name;
        this.salary = age;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }
}
