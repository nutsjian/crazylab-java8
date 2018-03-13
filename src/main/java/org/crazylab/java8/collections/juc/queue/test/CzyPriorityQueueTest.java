package org.crazylab.java8.collections.juc.queue.test;

import org.crazylab.java8.collections.juc.queue.CzyPriorityQueue;

public class CzyPriorityQueueTest {

    public static void main(String[] args) {
        CzyPriorityQueue<String> queue = new CzyPriorityQueue<>();
        queue.add("1");
        queue.add("2");
        queue.poll();
    }

}
