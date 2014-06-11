package com.themisinc.lab1;

/**
 * Created by Administrator on 6/11/2014.
 */
public class SavingsAccountTest {
    public static void main(String[] args) throws NegativeAmountException, InsufficientFundsException, NegativeInterestRateExeption {
        try {
            SavingsAccount sa = new SavingsAccount("dude", 1000.0);
            System.out.println(sa);
            sa.deposit(100.00);
            System.out.println(sa);
            sa.withdraw(200.00);
            System.out.println(sa);
            sa.postInterest();
            System.out.println(sa);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
