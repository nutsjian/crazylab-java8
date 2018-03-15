package org.crazylab.java8.jvm;

public class ClassLoadDemo01 {

    // 同时被 static 和 final 修饰的常量，必须在声明的时候就为其显式地赋值
    private static final int a = 99;
    // 只被 final 修饰的常量，既可以在声明时显式地赋值，也可以在类初始化时显式地为其赋值
    private final int b;
    private final int c = 3;

    public ClassLoadDemo01() {
        b = 1;
    }
}
