package com.raveture.employee;

public  abstract class Employee {
    private String empName;
    private int empId;
    private String empDept;

    public Employee() {}

    public Employee(String empName, int empId, String empDept) {
        this.empName = empName;
        this.empId = empId;
        this.empDept = empDept;
    }
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public int getEmpId() {
        return empId;
    }
    public abstract double pay();


}
