package org.crazylab.java8.constantpool;

public class StringPoolDemo01 {
    public static void main(String[] args) {
        String a = "xyz";
        String b = new String("xyz");
        String c = "xyz";
        String d = new String("xyz");
        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(a == c);
        System.out.println(b == d);
    }
}
