package org.crazylab.java8.constantpool;

import java.util.Random;

public class RuntimeTest {
    static {
        System.out.println("Runtime Test was loaded");
    }
    public static final int a = new Random().nextInt();
}
