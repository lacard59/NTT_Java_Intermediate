package com.themisinc.JavaBean.app;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 6/13/2014.
 */
public class BankAccount implements Serializable, Comparable<BankAccount> {

    private static final long serialVersionUID = -4703465563583212014L;
    private String name;
    private double balance;
    private int acctNumber;
    private Date dateOpened;
    private AccountType type;

    @Deprecated
    public BankAccount(){
        dateOpened = new Date(2000,1,1);
    }

    public BankAccount(String name, double balance, int acctNumber, Date dateOpened, AccountType type)
            throws NegativeAmountException, InvalidNameException{
        setName(name);;
        setBalance(balance);
        setAcctNumber(acctNumber);
        setDateOpened(dateOpened);
        setType(type);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidNameException{
        if (name.length() < 2){
            throw new InvalidNameException("Name is too short, son! Make it at least 2 characters long!!!");
        }
        else if (name.length() > 20){
            throw new InvalidNameException("Good try, son! Make the name at most 20 characters long!!!");
        }
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) throws NegativeAmountException {
        if (balance < 0){
            throw new NegativeAmountException("Balance can't be negative, son!");
        }
        this.balance = balance;
    }

    public int getAcctNumber() {
        return acctNumber;
    }

    public void setAcctNumber(int acctNumber) {
        this.acctNumber = acctNumber;
    }

    public Date getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(Date dateOpened) {
        this.dateOpened = dateOpened;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", acctNumber=" + acctNumber +
                ", dateOpened=" + dateOpened +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;

        BankAccount that = (BankAccount) o;

        if (acctNumber != that.acctNumber) return false;
        if (Double.compare(that.balance, balance) != 0) return false;
        if (dateOpened != null ? !dateOpened.equals(that.dateOpened) : that.dateOpened != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + acctNumber;
        result = 31 * result + (dateOpened != null ? dateOpened.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(BankAccount o) {
        return acctNumber - o.acctNumber;
    }
}
