package org.crazylab.java8.collections.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add(1, "123");
        list.add("asdasd");
        List<String> colls = new ArrayList<>();
        colls.add("123");
        colls.add("456");
        list.addAll(4, colls);

//        list.listIterator()

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("jange");
        arrayList.add(1, "chin");
        arrayList.addAll(colls);
    }

}
