package org.crazylab.java8.collections.juc.demo.set;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetDemo01 {

    public static void main(String[] args) {
        CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
        boolean a = set.add("a");
        System.out.println(a);
        a = set.add("b");
        System.out.println(a);
        a = set.add("a");
        System.out.println(a);

        a = set.add("c");
        a = set.add("d");
        a = set.add("e");
        a = set.add("f");
        List<String> colls = new ArrayList<>();
        colls.add("g");
        colls.add("h");
        a = set.addAll(colls);
        System.out.println(a);

        List<String> colls1 = new ArrayList<>();
        colls1.add("h");
        colls1.add("g");
        a = set.addAll(colls1);
        System.out.println(a);
    }

}
