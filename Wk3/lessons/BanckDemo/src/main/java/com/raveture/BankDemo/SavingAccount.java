package com.raveture.BankDemo;

public class SavingAccount extends BankAccount implements SimpleInterest{

    public SavingAccount() {
    }

    public SavingAccount(String accountId, String accountName, double Balance) {
        super(accountId, accountName, Balance);
    }

    @Override
    public String toString() {
        return "SavingAccount{}" + super.toString();
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
        double balance = super.getBalance();
        balance-=amount;
        super.setBalance(balance);
        return balance;
    }

    @Override
    public double calculateInterest(double amount) {
        return 0;
    }
}
