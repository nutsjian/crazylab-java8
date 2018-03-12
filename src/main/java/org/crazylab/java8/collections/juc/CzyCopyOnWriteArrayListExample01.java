package org.crazylab.java8.collections.juc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CzyCopyOnWriteArrayListExample01 {

    public static void main(String[] args) {
        CzyCopyOnWriteArrayList<String> list = new CzyCopyOnWriteArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Runnable runner1 = () -> {
//            list.add()
        };
    }

}
