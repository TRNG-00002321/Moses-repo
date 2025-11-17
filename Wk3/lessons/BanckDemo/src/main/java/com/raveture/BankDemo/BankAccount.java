package com.raveture.BankDemo;

public abstract class BankAccount   {
    private String accountId;
    private String accountName;
    private double balance;

    public BankAccount() {

    }

    public BankAccount(String accountId, String accountName, double initialBalance) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.balance = initialBalance;
    }

    @Override
    public String toString() {
        return "BankManager{" +
                "accountId='" + accountId + '\'' +
                ", accountName='" + accountName + '\'' +
                ", balance=" + balance +
                '}';
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double deposit(double amount){
        try {

        }

        return balance+=amount;
    }
    public abstract double withdraw(int amount);


}
