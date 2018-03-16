package org.crazylab.java8.jvm.classloader;

import java.io.*;

public class FileClassLoader extends ClassLoader {

    private final String rootDir;

    public FileClassLoader(String rootDir) {
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


//    @Override
//    protected Class<?> findClass(String name) throws ClassNotFoundException {
//        return super.findClass(name);
//    }

    private byte[] getClassBytes(String className) {
        String path  = this.rootDir + File.separatorChar + className.replace('.', File.separatorChar) + ".class";

        try {
            InputStream is = new FileInputStream(path);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead = 0;
            // 读取类文件的字节码
            while ((bytesNumRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesNumRead);
            }
            return os.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
