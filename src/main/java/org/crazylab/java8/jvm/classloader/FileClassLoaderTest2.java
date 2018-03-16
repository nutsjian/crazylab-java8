package org.crazylab.java8.jvm.classloader;

import sun.misc.Launcher;

public class FileClassLoaderTest2 {

    public static void main(String[] args) {
        String rootDir = "H:/workspace/tr0ck/crazylab-java8/target/classes";
        try {
            FileClassLoader cl1 = new FileClassLoader(rootDir);
            Class<?> userClassObject1 = cl1.loadClass("org.crazylab.java8.jvm.classloader.UserClass");

            FileClassLoader cl2 = new FileClassLoader(rootDir);
            Class<?> userClassObject2 = cl2.loadClass("org.crazylab.java8.jvm.classloader.UserClass");

            System.out.println(userClassObject1.hashCode());
            System.out.println(userClassObject2.hashCode());
            System.out.println(UserClass.class.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
