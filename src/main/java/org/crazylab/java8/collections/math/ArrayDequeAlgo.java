package org.crazylab.java8.collections.math;

import org.crazylab.java8.collections.common.queue.CzyArrayDeque;

import java.util.LinkedList;

public class ArrayDequeAlgo {

    public static void main(String[] args) {
        System.out.println(6 & 8);
        System.out.println(7 & 8);
        System.out.println(8 & 8);

        CzyArrayDeque<String> deque = new CzyArrayDeque<>(7);
//        deque.add("a");
//        deque.add("b");
//        deque.addFirst("c");
//        deque.pollLast();
//        deque.pollLast();
//        deque.pollLast();
//        deque.pollLast();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        deque.offerFirst("a");

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addFirst("a");
    }

}
