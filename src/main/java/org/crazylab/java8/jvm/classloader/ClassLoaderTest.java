package org.crazylab.java8.jvm.classloader;

public class ClassLoaderTest {

    public static void main(String[] args) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        System.out.println(cl);
        System.out.println(cl.getParent());
        System.out.println(cl.getParent().getParent());
    }

}
