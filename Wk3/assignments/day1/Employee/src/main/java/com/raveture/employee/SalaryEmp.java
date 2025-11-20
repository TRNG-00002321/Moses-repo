package com.raveture.employee;

public class SalaryEmp extends Employee implements EmployeeInterface {
    public SalaryEmp(){}
    public SalaryEmp(String empName, int empId, String empDept, double empHrs) {
        super( empName, empId, empDept)

    }

    @java.lang.Override
    public java.lang.String toString() {
        return "SalaryEmp{}";
    }
    public displayEmployeeDetails(){
        System.out.println("Employee Name: " + getEmpName());
        System.out.println("Employee ID: " + getEmpId());
        System.out.println("Employee Department: " + getEmpDept());
        System.out.println("Benefits: " + benefits);
    };

    public abstract double pay(){
        return 10000;
    };


}
