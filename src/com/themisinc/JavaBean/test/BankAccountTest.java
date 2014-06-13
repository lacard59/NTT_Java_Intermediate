package com.themisinc.JavaBean.test;

import com.themisinc.JavaBean.app.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.*;


public class BankAccountTest {

    public BankAccount ba;

    @Before
    public void setUp() throws Exception{
        ba = new BankAccount("test",50.00,12345,new Date(0),AccountType.SAVING);
    }

    @Test
    public void testContructorShortName() throws Exception{
        try{
            ba = new BankAccount("t", 50.00, 12345, new Date(0), AccountType.SAVING);
            fail("Invalid Name Exception should have been caught!");
        } catch (InvalidNameException e){
            assertEquals("Name is too short, son! Make it at least 2 characters long!!!", e.getMessage());
        }
    }

    @Test
    public void testConstructorLongName() throws Exception{
        try{
            ba = new BankAccount("asdlfkasldkfjasl;dkjasl;dkfjal;ksjdf;lkajsdft", 50.00, 12345, new Date(0), AccountType.SAVING);
            fail("Invalid Name Exception should have been caught!");
        } catch (InvalidNameException e){
            assertEquals("Good try, son! Make the name at most 20 characters long!!!", e.getMessage());
        }
    }

    @Test
    public void testConstructorNegativeBalance() throws Exception{
        try{
            ba = new BankAccount("GoodName", -50.00, 12345, new Date(0), AccountType.SAVING);
            fail("Negative Amount Exception should have been caught!");
        } catch (NegativeAmountException e){
            assertEquals("Balance can't be negative, son!", e.getMessage());
        }
    }

    @Test
    public void testConstructorNormal() throws Exception{
        ba = new BankAccount("GoodName", 50.00, 12345, new Date(0), AccountType.SAVING);
        assertEquals("GoodName", ba.getName());
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
    public void testSetNameTooShort() throws Exception{
        try{
            ba.setName("a");
            fail("Invalid Name Exception should have been caught!");
        } catch (InvalidNameException e){
            assertEquals("Name is too short, son! Make it at least 2 characters long!!!", e.getMessage());
        }
    }

    @Test
    public void testSetNameTooLong() throws Exception{
        try{
            ba.setName("askdjalsiwmnckowjdlkajwoijdkjclkja");
            fail("Invalid Name Exception should have been caught!");
        } catch (InvalidNameException e){
            assertEquals("Good try, son! Make the name at most 20 characters long!!!", e.getMessage());
        }
    }

    @Test
    public void testSetNameJustRight() throws Exception{
        ba.setName("Good Test Name");
        assertEquals("Good Test Name", ba.getName());
    }

    @Test
    public void testToString() {
//        System.out.println(ba.toString());
        assertEquals("BankAccount{name='test', balance=50.0, acctNumber=12345, dateOpened=Wed Dec 31 19:00:00 EST 1969}", ba.toString());
    }

    @Test
    public void testEqualsTrue() throws Exception{
        BankAccount ba2;
        ba2 = new BankAccount();
        ba2.setName("test");
        ba2.setBalance(50.00);
        ba2.setAcctNumber(12345);
        ba2.setDateOpened(new Date(0));
        boolean compare = ba.equals(ba2);
        assertEquals(true, compare);
    }

    @Test
    public void testEqualsFalse() throws Exception{
        BankAccount ba2;
        ba2 = new BankAccount();
        ba2.setName("test");
        ba2.setBalance(49.99);           //Changed field by 0.01
        ba2.setAcctNumber(12345);
        ba2.setDateOpened(new Date(0));
        boolean compare = ba.equals(ba2);
        assertEquals(false, compare);
    }

    @Test
    public void testComparableNotSorted() throws Exception{
        BankAccount[]  baArr = new BankAccount[3];
        baArr[0] = new BankAccount("dude2", 50.00, 4, new Date(0), AccountType.SAVING);
        baArr[1] = new BankAccount("dude3", 50.00, 10, new Date(0), AccountType.SAVING);
        baArr[2] = new BankAccount("dude1", 50.00, 2, new Date(0), AccountType.SAVING);
        String compare = "";
        for (int i = 0; i < baArr.length; i++) {
            compare += baArr[i].getName();
        }
        assertEquals("dude2dude3dude1", compare);
    }

    @Test
    public void testComparableSorted() throws Exception{
        BankAccount[]  baArr = new BankAccount[3];
        baArr[0] = new BankAccount("dude2", 50.00, 4, new Date(0), AccountType.SAVING);
        baArr[1] = new BankAccount("dude3", 50.00, 10, new Date(0), AccountType.SAVING);
        baArr[2] = new BankAccount("dude1", 50.00, 2, new Date(0), AccountType.SAVING);
        Arrays.sort(baArr);
        String compare = "";
        for (int i = 0; i < baArr.length; i++) {
            compare += baArr[i].getName();
        }
        assertEquals("dude1dude2dude3", compare);
    }

    @Test
    public void testComparatorNotSorted() throws Exception{
        BankAccount[] baArr = new BankAccount[4];
        String compare = "";
        baArr[0] = new BankAccount("Larz", 50.00, 19182, new Date(0), AccountType.SAVING);
        baArr[1] = new BankAccount("Isaiah", 50.00, 83297, new Date(0), AccountType.SAVING);
        baArr[2] = new BankAccount("Sepideh", 50.00, 20984, new Date(0), AccountType.SAVING);
        baArr[3] = new BankAccount("Ky", 50.00, 398746, new Date(0), AccountType.SAVING);
        for (int i = 0; i < baArr.length; i++) {
            compare += baArr[i].getName() + "," + baArr[i].getAcctNumber();
        }
        assertEquals("Larz,19182Isaiah,83297Sepideh,20984Ky,398746",compare);

    }

    @Test
    public void testComparatorSorted() throws Exception{
        BankAccount[] baArr = new BankAccount[4];
        String compare = "";
        baArr[0] = new BankAccount("Larz", 50.00, 19182, new Date(0), AccountType.SAVING);
        baArr[1] = new BankAccount("Isaiah", 50.00, 83297, new Date(0), AccountType.SAVING);
        baArr[2] = new BankAccount("Sepideh", 50.00, 20984, new Date(0), AccountType.SAVING);
        baArr[3] = new BankAccount("Ky", 50.00, 398746, new Date(0), AccountType.SAVING);
        Arrays.sort(baArr, new BankAccCompareByName());
        for (int i = 0; i < baArr.length; i++) {
            compare += baArr[i].getName() + "," + baArr[i].getAcctNumber();
        }
        assertEquals("Isaiah,83297Ky,398746Larz,19182Sepideh,20984",compare);
    }

    @Test
    public void testSetProperty1(){
        ba.setType(AccountType.CHECKING);
        assertEquals(AccountType.CHECKING, ba.getType());
    }

    @Test
    public void testSetProperty2(){
        ba.setType(AccountType.SAVING);
        assertEquals(AccountType.SAVING, ba.getType());
    }

    @Test
    public void testSetProperty3(){
        ba.setType(AccountType.IRA);
        assertEquals(AccountType.IRA, ba.getType());
    }

    @Test
    public void testSetProperty4(){
        ba.setType(AccountType.ROTHIRA);
        assertEquals(AccountType.ROTHIRA, ba.getType());
    }

    @Test
    public void testSetProperty5(){
        ba.setType(AccountType.SEPIRA);
        assertEquals(AccountType.SEPIRA, ba.getType());
    }
}