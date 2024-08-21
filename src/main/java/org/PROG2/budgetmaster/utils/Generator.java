package org.PROG2.budgetmaster.utils;

public class Generator {

    public static String id(){
        return Long.toHexString(System.currentTimeMillis());
    }
}
