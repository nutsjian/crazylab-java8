package org.crazylab.java8.utils;

import java.lang.instrument.Instrumentation;

public class Sizeof {

    private static Instrumentation instrumentation;

    public static long getObjectSize(Object o) {
        return instrumentation.getObjectSize(o);
    }

    public static void main(String[] args) {
        System.out.println(getObjectSize(new String("asd")));
    }

}
