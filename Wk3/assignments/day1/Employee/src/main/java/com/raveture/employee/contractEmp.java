package com.raveture.employee;

public class contractEmp extends Employee {
    private int contractDuration; // in months
    private double hourlyRate;

    public contractEmp() {}

    public contractEmp(String empName, int empId, String empDept, int contractDuration, double hourlyRate) {
        super(empName, empId, empDept);
        this.contractDuration = contractDuration;
        this.hourlyRate = 18;
    }

    public int getContractDuration() {
        return contractDuration;
    }

    public void setContractDuration(int contractDuration) {
        this.contractDuration = contractDuration;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double pay(){
        return contractDuration * hourlyRate;
    }

}
