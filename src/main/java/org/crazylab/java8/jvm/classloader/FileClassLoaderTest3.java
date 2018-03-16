package org.crazylab.java8.jvm.classloader;

public class FileClassLoaderTest3 {

    public static void main(String[] args) {
        String rootDir = "H:";
        try {
            FileClassLoader cl1 = new FileClassLoader(rootDir);
            Class<?> userClassObject1 = cl1.loadClass("classloader.UserClass");

            FileClassLoader cl2 = new FileClassLoader(rootDir);
            Class<?> userClassObject2 = cl2.loadClass("classloader.UserClass");

            System.out.println(userClassObject1.hashCode());
            System.out.println(userClassObject2.hashCode());
            System.out.println(UserClass.class.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
