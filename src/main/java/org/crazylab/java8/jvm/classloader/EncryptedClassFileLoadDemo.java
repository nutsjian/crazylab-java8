package org.crazylab.java8.jvm.classloader;

import java.io.*;

public class EncryptedClassFileLoadDemo {

    public static void main(String[] args) {
        String rootDir = "H:";
        try {
            FileClassLoader cl1 = new FileClassLoader(rootDir);
            Class<?> userClassObject1 = cl1.loadClass("classloader.UserClass");
            System.out.println(userClassObject1.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class EncryptedFileClassLoader extends ClassLoader {
        private final String rootDir;

        public EncryptedFileClassLoader(String rootDir) {
            this.rootDir = rootDir;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            // 获取类的字节数组
            byte[] classBytes = getClassBytes(name);
            if (classBytes == null) {
                throw new ClassNotFoundException(name);
            } else {
                // 调用 defineClass 方法生成相应的 Class 对象
                return defineClass(name, classBytes, 0, classBytes.length);
            }
        }

        private byte[] getClassBytes(String className) {
            String path  = this.rootDir + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
            try {
                InputStream is = new FileInputStream(path);
                ByteArrayOutputStream os = new ByteArrayOutputStream();
//                int bufferSize = 1024;
//                byte[] buffer = new byte[bufferSize];
                int len = 0;
                byte b;
                // 读取类文件的字节码
                while ((len = is.read()) != -1) {
                    b = (byte) (len ^ 2);
//                    bytesNumRead = (byte)(bytesNumRead ^ 2);
//                    os.write(buffer, 0, bytesNumRead);
                    os.write(b);
                }
                return os.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}
