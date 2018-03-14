package org.crazylab.java8.constantpool;

public class StringPoolDemo04 {
    public static void main(String[] args) {
        String a = "ab";
        String b = "a" + "b";       // 在编译器会被优化成 "ab"
        System.out.println(a == b);

        String x = "xy";
        String y = "x".concat("y");
        System.out.println(x == y);
    }
}
