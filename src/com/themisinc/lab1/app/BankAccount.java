package com.themisinc.lab1.app;

import java.util.Date;

/**
 * Created by Administrator on 6/11/2014.
 */
public class BankAccount  {

    private String name;
    private double balance;
    private int acctNumber;
    private Date dataOpenened;

    /**
     * Getter method for private variable "name"
     * @return returns the name of the Bank Account
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for private variable "name"
     * @param name name of the Bank Account
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for private variable "balance"
     * @return returns the balance of the Bank Account
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Setter method for private variable "balance"
     * @param balance balance to set to the Bank Account
     * @throws NegativeAmountException exception that handles a negative balance
     */
    public void setBalance(double balance) throws NegativeAmountException{
        if (balance < 0){
            throw new NegativeAmountException("Balance can't be negative, son!");
        }
        this.balance = balance;
    }

    /**
     * Constructor for the BankAccount Object
     * Takes the name and balance given and creates a
     * new Bank Account with the given name and balance
     * @param name name of the Bank Account
     * @param balance balance to set to the Bank Account
     * @throws NegativeAmountException exception that handles a negative balance
     */
    public BankAccount (String name, double balance) throws NegativeAmountException {
        setName(name);
        setBalance(balance);
    }

    /**
     * Constructor for the BankAccount Object
     * Takes the name given and creates a new
     * Bank Account with that name and a balance of 0.0
     * @param name name of the Bank Account
     * @throws NegativeAmountException exception that handles a negative balance
     */
    public BankAccount (String name) throws NegativeAmountException {
        setName(name);
        setBalance(0.0);
    }

    /**
     * Method that handle a deposit to a Bank Account
     * @param amount amount of money you want to deposit into a Bank Account
     * @throws NegativeAmountException exception that handles a negative deposit amount
     */
    public void deposit(double amount) throws NegativeAmountException{
        if (amount < 0){
            throw new NegativeAmountException("Enter a valid number. Can't deposit a negative amount.");
        }
        setBalance(getBalance() + amount);
    }

    /**
     * Method that handles a withdraw from a Bank Account
     * @param amount amount of money you want to withdraw from a Bank Account
     * @throws InsufficientFundsException exception that handles a withdraw amount that is higher than the current balance
     * @throws NegativeAmountException exception that handles a negative withdraw amount
     */
    public void withdraw(double amount) throws InsufficientFundsException, NegativeAmountException{
        if (amount > getBalance()){
            throw new InsufficientFundsException("Can't withdraw amount. You have insufficient funds.");
        }
        else if (amount < 0){
            throw new NegativeAmountException("Enter a valid number. Can't withdraw a negative amount.");
        }
        setBalance(getBalance() - amount);
    }

    /**
     * toString Method for the BankAccount Object
     * @return returns the Bank Account name and balance.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BankAccount{");
        sb.append("name='").append(name).append('\'');
        sb.append(", balance=").append(balance);
        sb.append('}');
        return sb.toString();
    }
}