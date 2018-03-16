package org.crazylab.java8.jvm.classloader;

import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

public class UserURLClassLoader extends URLClassLoader {
    public UserURLClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public UserURLClassLoader(URL[] urls) {
        super(urls);
    }

    public UserURLClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        return super.loadClass(name, resolve);
    }
}
