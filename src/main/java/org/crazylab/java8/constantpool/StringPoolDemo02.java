package org.crazylab.java8.constantpool;

public class StringPoolDemo02 {
    public static void main(String[] args) {
        String a = "ab";
        String bb = "b";
        String b = "a" + bb;            // bb是引用的值，在编译期无法确定，需要运行期动态分配，所以"a" + bb就在堆内存中开启了内存，所以 a 的引用地址不可能等于 b 的引用地址
        System.out.println((a == b));
    }
}
