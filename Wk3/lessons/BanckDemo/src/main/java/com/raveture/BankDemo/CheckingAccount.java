package com.raveture.BankDemo;

public class CheckingAccount extends BankAccount{

    public CheckingAccount() {
    }

    public CheckingAccount(String accountId, String accountName, double Balance) {
        super(accountId, accountName, Balance);
    }

    @Override
    public String toString() {
        return "CheckingAccount{}" + super.toString();
    }

    @Override
    public double deposit(double amount) {
        if (amount <= 0){
            try {
                throw new DepositeException(amount);
            } catch (DepositeException e) {
                System.out.println(e.getMessage());
            }
        }
        return super.deposit(amount);
    }

    @Override
    public double withdraw(int amount){
        // exceptions for insufficient funds for amount if balance is less than 500
        try {
            if (super.getBalance() - amount < 500) {
                throw new InsufficientFundsException();
            }
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
            return super.getBalance();
        }
        return super.getBalance() - amount;
    }

}
