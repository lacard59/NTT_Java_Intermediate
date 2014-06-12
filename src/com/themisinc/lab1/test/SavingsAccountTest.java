package com.themisinc.lab1.test;

import com.themisinc.lab1.app.NegativeInterestRateException;
import com.themisinc.lab1.app.SavingsAccount;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SavingsAccountTest {
    SavingsAccount sa;

    @Before
    public void setUp() throws Exception {
        sa = new SavingsAccount("test", 50.0, 5.0);
    }

    @Test
    public void testSavingsAccountNegativeInterest() throws Exception {
        try {
            sa = new SavingsAccount("test", 50.0, -5.0);
            fail("Negative Interest Exception should be caught!");
        } catch (NegativeInterestRateException e) {
            assertEquals("COME ON! You can't have a NEGATIVE interest!",e.getMessage());
        }
    }

    @Test
    public void testSavingAccountPositiveInterest() throws Exception {
        sa = new SavingsAccount("test", 50.0, 20);
        assertEquals(20.0, 20.00, 0);
    }

    @Test
    public void testSavingAccountNoBalanceNegativeInterest() throws Exception {
        try {
            sa = new SavingsAccount("test", -5.0);
            fail("Negative Interest Exception should be caught!");
        } catch (NegativeInterestRateException e) {
            assertEquals("COME ON! You can't have a NEGATIVE interest!",e.getMessage());
        }
    }

    @Test
    public void testSavingAccountNoBalancePositiveInterest() throws Exception {
        sa = new SavingsAccount("test", 20);
        assertEquals(20.0, 20.00, 0);
    }

    @Test
    public void testSetInterestRateNegative() throws Exception {
        try {
            sa.setInterestRate(-10);
            fail("Negative Interest Exception should be caught!");
        } catch (NegativeInterestRateException e) {
            assertEquals("COME ON! You can't have a NEGATIVE interest!", e.getMessage());
        }
    }

    @Test
    public void testSetInterestRatePositive() throws Exception {
        sa.setInterestRate(10.00);
        assertEquals(10.00, sa.getInterestRate(), 0);
    }

    @Test
    public void testPostInterest() throws Exception {
        sa.postInterest();
        assertEquals(50.21, sa.getBalance(), 0.01);
    }

    @Test
    public void testSetName() throws Exception {
        sa.setName("testytesty");
        assertEquals("testytesty", sa.getName());
    }
}