package com.themisinc.JavaBean.app;

/**
 * Created by Administrator on 6/13/2014.
 */
public class InvalidNameException extends Exception {
    public InvalidNameException(){
    }

    public InvalidNameException(String str){
        super(str);
    }
}
