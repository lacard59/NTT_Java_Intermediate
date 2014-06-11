package com.themisinc.lab1;

/**
 * Created by Administrator on 6/11/2014.
 */
public class SavingsAccount extends BankAccount {

    private double interestRate = 5.00;

    public SavingsAccount(String name, double balance) throws NegativeAmountException {
        super(name, balance);
    }

    public SavingsAccount(String name) throws NegativeAmountException {
        super(name);
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) throws NegativeInterestRateExeption{
        if (interestRate < 0.00) {
            throw new NegativeInterestRateExeption("COME ON! You can't have a NEGATIVE interest!");
        }
        this.interestRate = interestRate;
    }

    public void postInterest() throws NegativeAmountException{
        double interest = (getBalance() * getInterestRate()) / 1200;
        setBalance(getBalance() + interest);
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "interestRate=" + interestRate +
                "} " + super.toString();
    }

}
