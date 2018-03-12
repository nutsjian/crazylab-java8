package org.crazylab.java8.collections.common.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        list.add("123");

        list.remove("asd");

        list.contains("adasdasd");
    }
}
