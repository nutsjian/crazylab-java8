package org.crazylab.java8.collections.juc.demo.queue;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo01 {

    public static void main(String[] args) {
        SynchronousQueue<String> queue = new SynchronousQueue<>();
        queue.add("123");
    }

}
