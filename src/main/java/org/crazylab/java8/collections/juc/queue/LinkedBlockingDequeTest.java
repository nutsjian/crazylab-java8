package org.crazylab.java8.collections.juc.queue;

import java.util.concurrent.LinkedBlockingDeque;

public class LinkedBlockingDequeTest {

    public static void main(String[] args) {
        LinkedBlockingDeque<String> queue = new LinkedBlockingDeque<>();
        queue.add("a");
        queue.add("b");
        queue.add("c");

        queue.offer("d");
    }

}
