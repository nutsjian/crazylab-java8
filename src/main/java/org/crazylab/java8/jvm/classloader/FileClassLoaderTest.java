package org.crazylab.java8.jvm.classloader;

public class FileClassLoaderTest {

    public static void main(String[] args) {
        String rootDir = "H:/workspace/tr0ck/crazylab-java8/target/classes";
        try {
            FileClassLoader cl1 = new FileClassLoader(rootDir);
            Class<?> userClassObject1 = cl1.findClass("org.crazylab.java8.jvm.classloader.UserClass");

            FileClassLoader cl2 = new FileClassLoader(rootDir);
            Class<?> userClassObject2 = cl2.findClass("org.crazylab.java8.jvm.classloader.UserClass");

            System.out.println(userClassObject1.hashCode());
            System.out.println(userClassObject2.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
