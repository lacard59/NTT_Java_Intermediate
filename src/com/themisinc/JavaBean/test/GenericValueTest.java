package com.themisinc.JavaBean.test;

import com.themisinc.JavaBean.app.GenericValue;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenericValueTest {
    GenericValue gv;

    @Test
    public void testSetX() throws Exception {
        gv.setValue(48);
        assertEquals(48,gv.getValue());
    }
}