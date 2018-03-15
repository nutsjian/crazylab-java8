package org.crazylab.java8.jvm;

public class Child extends Father {
    public static int b = 90;
    public static final int c = 100;
    static {
        System.out.println("子类被初始化");
    }
}
