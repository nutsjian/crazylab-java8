package org.crazylab.java8.jvm.classloader;

import java.io.File;
import java.net.URI;
import java.net.URL;

public class UserURLClassLoaderTest {
    public static void main(String[] args) {
        try {
            String rootDir = "/Users/zejian/Downloads/Java8_Action/src/main/java/";
            //创建自定义文件类加载器
            File file = new File(rootDir);
            //File to URI
            URI uri = file.toURI();
            URL[] urls = {uri.toURL()};
            UserURLClassLoader loader = new UserURLClassLoader(urls);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
