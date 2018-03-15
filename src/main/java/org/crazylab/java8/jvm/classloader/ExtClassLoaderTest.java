package org.crazylab.java8.jvm.classloader;

import java.io.File;
import java.util.StringTokenizer;

public class ExtClassLoaderTest {

    public static void main(String[] args) {
        File[] dirs = getExtDirs();
        for(File file : dirs) {
            System.out.println(file.getName());
        }
    }

    private static File[] getExtDirs() {
        String s = System.getProperty("java.ext.dirs");
        File[] dirs;
        if (s != null) {
            StringTokenizer st = new StringTokenizer(s, File.pathSeparator);
            int count = st.countTokens();
            dirs = new File[count];
            for (int i=0; i<count; i++) {
                dirs[i] = new File(st.nextToken());
            }
        } else {
            dirs = new File[0];
        }

        return dirs;
    }

}
