package com.themisinc.lab1;

/**
 * Created by Administrator on 6/11/2014.
 */
public class BankAccount  {

    private String name;
    private double balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) throws NegativeAmountException{
        if (balance < 0){
            throw new NegativeAmountException("Balance can't be negative, son!");
        }
        this.balance = balance;
    }

    public BankAccount (String name, double balance) throws NegativeAmountException {
        setName(name);
        setBalance(balance);
    }

    public BankAccount (String name) throws NegativeAmountException {
        setName(name);
        setBalance(0.0);
    }

    public void deposit(double amount) throws NegativeAmountException{
        if (amount < 0){
            throw new NegativeAmountException("Enter a valid number. Can't deposit a negative amount.");
        }
        setBalance(getBalance() + amount);
    }

    public void withdraw(double amount) throws InsufficientFundsException, NegativeAmountException{
        if (amount > getBalance()){
            throw new InsufficientFundsException("Can't withdraw amount. You have insufficient funds.");
        }
        else if (amount < 0){
            throw new NegativeAmountException("Enter a valid number. Can't withdraw a negative amount.");
        }
        setBalance(getBalance() - amount);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BankAccount{");
        sb.append("name='").append(name).append('\'');
        sb.append(", balance=").append(balance);
        sb.append('}');
        return sb.toString();
    }

}
