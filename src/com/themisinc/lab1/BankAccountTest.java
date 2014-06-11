package com.themisinc.lab1;

/**
 * Created by Administrator on 6/11/2014.
 */
public class BankAccountTest {
    public static void main(String[] args) throws NegativeAmountException, InsufficientFundsException {
        BankAccount ba = new BankAccount("test", 50.0);
        System.out.println(ba);
    }
}
