package com.raveture.employee;

public class SalaryEmp extends Employee implements EmployeeInterface {
    public SalaryEmp(){}
    public SalaryEmp(String empName, int empId, String empDept, double empHrs) {
        super( empName, empId, empDept)
        this.empHrs = empHrs
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "SalaryEmp{}";
    }


}
