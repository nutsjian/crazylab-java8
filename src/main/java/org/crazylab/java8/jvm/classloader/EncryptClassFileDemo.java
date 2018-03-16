package org.crazylab.java8.jvm.classloader;

import java.io.*;

public class EncryptClassFileDemo {

    public static void main(String[] args) {
        String path = "H:/classloader/UserClass.class";
        File file = new File(path);
        try {
            InputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(path + "en");
            int b;
            while((b = fis.read()) != -1){
                //每一个byte异或一个数字2
                fos.write(b ^ 2);
            }
            fos.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
