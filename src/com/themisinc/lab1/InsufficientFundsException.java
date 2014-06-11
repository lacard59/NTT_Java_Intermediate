package com.themisinc.lab1;

/**
 * Created by Administrator on 6/11/2014.
 */
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(){
    }

    public InsufficientFundsException(String str){
        super(str);
    }
}
