package org.crazylab.java8.collections.juc.demo.list;

import org.crazylab.java8.collections.juc.CzyCopyOnWriteArrayList;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CopyOnWriteArrayListDemo01 {

    public static void main(String[] args) {
        CzyCopyOnWriteArrayList<String> list = new CzyCopyOnWriteArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Runnable runner1 = () -> {
//            list.add()
        };
    }

}
