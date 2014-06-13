package com.themisinc.JavaBean.app;

import com.themisinc.lab1.app.*;

import java.io.Serializable;

/**
 * Created by Administrator on 6/13/2014.
 */
public class SavingsAccount extends BankAccount implements Serializable {

    private static final long serialVersionUID = -7184524026474682605L;
    private double interestRate;

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) throws NegativeInterestRateException {
        if (interestRate < 0.00) {
            throw new NegativeInterestRateException("COME ON! You can't have a NEGATIVE interest!");
        }
        this.interestRate = interestRate;
    }

    public SavingsAccount(){
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "interestRate=" + interestRate +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SavingsAccount)) return false;
        if (!super.equals(o)) return false;

        SavingsAccount that = (SavingsAccount) o;

        if (Double.compare(that.interestRate, interestRate) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(interestRate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
