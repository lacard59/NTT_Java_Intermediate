package com.themisinc.JavaBean.test;

import com.themisinc.JavaBean.app.NegativeInterestRateException;
import com.themisinc.JavaBean.app.SavingsAccount;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class SavingsAccountTest {

    public SavingsAccount sa;

    @Before
    public void setUp() throws Exception {
        sa = new SavingsAccount();
        sa.setInterestRate(5.00);
        sa.setAcctNumber(54321);
        sa.setName("test");
        sa.setDateOpened(new Date(0));
        sa.setBalance(50.00);
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
    public void testToString() throws Exception {
//        System.out.println(sa);
        assertEquals("SavingsAccount{interestRate=5.0} BankAccount{name='test', balance=50.0, acctNumber=54321, dateOpened=Wed Dec 31 19:00:00 EST 1969}", sa.toString());
    }

    @Test
    public void testEqualsTrue() throws Exception{
        SavingsAccount sa2;
        sa2 = new SavingsAccount();
        sa2.setInterestRate(5.00);
        sa2.setAcctNumber(54321);
        sa2.setName("test");
        sa2.setDateOpened(new Date(0));
        sa2.setBalance(50.00);
        boolean compare = sa.equals(sa2);
        assertEquals(true, compare);
    }

    @Test
    public void testEqualsFalse() throws Exception{
        SavingsAccount sa2;
        sa2 = new SavingsAccount();
        sa2.setInterestRate(4.99);      //Changed field by 0.01
        sa2.setAcctNumber(54321);
        sa2.setName("test");
        sa2.setDateOpened(new Date(0));
        sa2.setBalance(50.00);
        boolean compare = sa.equals(sa2);
        assertEquals(false, compare);
    }


}