package org.crazylab.java8.jvm;

public class StaticTest {
    public static void main(String[] args) {
//        System.out.println(Child.a);  // (1) Father 会初始化，Child 不会初始化
//        System.out.println(Child.b);  // (2) Father Child 都会初始化
        System.out.println(Child.c);    // (3) Father Clild 两个类都不会初始化
    }
}
