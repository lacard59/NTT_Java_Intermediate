package com.themisinc.lab1.app;

/**
 * Created by Administrator on 6/11/2014.
 */
public class SavingsAccount extends BankAccount {

    private double interestRate;

    public SavingsAccount(String name, double balance, double interest) throws NegativeAmountException, NegativeInterestRateException {
        super(name, balance);
        setInterestRate(interest);
    }

    public SavingsAccount(String name, double interest) throws NegativeAmountException, NegativeInterestRateException {
        super(name);
        setInterestRate(interest);
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) throws NegativeInterestRateException {
        if (interestRate < 0.00) {
            throw new NegativeInterestRateException("COME ON! You can't have a NEGATIVE interest!");
        }
        this.interestRate = interestRate;
    }

    public void postInterest(){
        try {
            double interest = (getBalance() * getInterestRate()) / 1200;
            setBalance(getBalance() + interest);
        } catch (NegativeAmountException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "interestRate=" + interestRate +
                "} " + super.toString();
    }

}
