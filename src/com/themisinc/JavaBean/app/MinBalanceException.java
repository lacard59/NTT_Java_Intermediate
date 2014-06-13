package com.themisinc.JavaBean.app;

/**
 * Created by Administrator on 6/13/2014.
 */
public class MinBalanceException extends Throwable {
    public MinBalanceException(){
    }

    public MinBalanceException(String str){
        super(str);
    }
}
