package com.themisinc.lab1.app;

/**
 * Created by Administrator on 6/11/2014.
 */
public class NegativeAmountException extends Exception {
    public NegativeAmountException() {
    }

    public NegativeAmountException(String str) {
        super(str);
    }

}
