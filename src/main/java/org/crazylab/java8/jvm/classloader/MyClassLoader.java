package org.crazylab.java8.jvm.classloader;

public class MyClassLoader extends ClassLoader {
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

    private byte[] getClassBytes(String name) {
        return new byte[0];
    }
}
