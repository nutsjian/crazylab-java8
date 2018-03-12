package org.crazylab.java8.collections.common.list;

import java.util.LinkedList;

public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("asd");
        list.getFirst();
        list.remove("abc");
        list.remove(1);
        list.remove();

        list.addFirst("asdasd");
        list.add("jjj");
        list.add(1, "vjaksjd");
    }

}
