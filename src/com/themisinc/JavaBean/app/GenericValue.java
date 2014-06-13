package com.themisinc.JavaBean.app;

import sun.net.www.content.text.Generic;

/**
 * Created by Administrator on 6/13/2014.
 */
public class GenericValue<X> {
    private X value;

    public X getValue() {
        return value;
    }

    public void setValue(X value) {
        this.value = value;
    }

    public GenericValue(){
        setValue(null);
    }

    public GenericValue(X value){
        setValue(value);
    }
}
