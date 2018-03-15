package org.crazylab.java8.jvm;

public class ClassLoaderDemo {

    public static void main(String[] args) {
        try {
//            Class<?> childClass = ClassLoader.getSystemClassLoader().loadClass("org.crazylab.java8.jvm.Child");
            ClassLoaderDemo.class.getClassLoader().loadClass("org.crazylab.java8.jvm.Child");
//            Class.forName("org.crazylab.java8.jvm.Child", true, ClassLoader.getSystemClassLoader());
        } catch (ClassNotFoundException e) {

        }
    }

}
