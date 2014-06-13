package com.themisinc.JavaBean.app;

import java.util.Comparator;

/**
 * Created by Administrator on 6/13/2014.
 */
public class BankAccCompareByName implements Comparator<BankAccount> {

    @Override
    public int compare(BankAccount o1, BankAccount o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
