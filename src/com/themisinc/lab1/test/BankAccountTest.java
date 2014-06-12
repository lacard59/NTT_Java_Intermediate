package com.themisinc.lab1.test;

import com.themisinc.lab1.app.BankAccount;
import com.themisinc.lab1.app.InsufficientFundsException;
import com.themisinc.lab1.app.NegativeAmountException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankAccountTest {
    private BankAccount ba;

    @Before
    public void setUp() throws Exception {
        ba = new BankAccount("test", 50.00);
    }

    @Test
    public void testBankAccountOneArgumentConstructor() throws Exception {
        ba = new BankAccount("testytesty");
        assertEquals("testytesty", ba.getName());
    }

    @Test
    public void testBankAccountPositiveAmount() throws Exception {
        ba = new BankAccount("test", 50.00);
        assertEquals("test", ba.getName());
        assertEquals(50.00, ba.getBalance(),0.02);
    }

    @Test
    public void testBankAccountNegativeAmount() throws Exception {
        try {
            ba = new BankAccount("test1", -50.00);
            fail("Exception for Negative Balance should be caught");
        } catch (NegativeAmountException e) {
            assertEquals("Balance can't be negative, son!", e.getMessage());
        }
    }

    @Test
    public void testSetName() throws Exception {
        ba.setName("dudeman");
        assertEquals("dudeman", ba.getName());
    }

    @Test
    public void testSetNegativeBalance() throws Exception {
        try {
            ba.setBalance(-10.00);
            fail("Exception for Negative Balance should be caught.");
        } catch (NegativeAmountException e) {
            assertEquals("Balance can't be negative, son!", e.getMessage());
        }
    }

    @Test
    public void testSetPositiveBalance() throws Exception {
        ba.setBalance(10.00);
        assertEquals(10.00, ba.getBalance(), 0.02);
    }

    @Test
    public void testDepositNegativeAmount() throws Exception {
        try {
            ba.deposit(-50.0);
            fail("Negative Amount Exception should be caught!");
        } catch (NegativeAmountException e) {
            assertEquals("Enter a valid number. Can't deposit a negative amount.", e.getMessage());
        }
    }

    @Test
    public void testDepositPositiveAmount() throws Exception {
        ba.deposit(50.0);
        assertEquals(100.0, ba.getBalance(), 0.02);
    }

    @Test
    public void testWithdrawInsufficientFunds() throws Exception {
        try{
            ba.withdraw(100.00);
            fail("Insufficient Amount Exception should be caught!");

        } catch (InsufficientFundsException e) {
            assertEquals("Can't withdraw amount. You have insufficient funds.", e.getMessage());
        }
    }

    @Test
    public void testWithdrawNegativeAmount() throws Exception {
        try{
            ba.withdraw(-100.00);
            fail("Negative Amount Exception should be caught!");

        } catch (NegativeAmountException e) {
            assertEquals("Enter a valid number. Can't withdraw a negative amount.", e.getMessage());
        }
    }

    @Test
    public void testWithdrawNormal() throws Exception {
        ba.withdraw(25.00);
        assertEquals(25.00, ba.getBalance(), 0.02);
    }
}