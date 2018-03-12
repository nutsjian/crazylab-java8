package org.crazylab.java8.collections.juc.queue;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;
import java.util.concurrent.*;

public class ArrayBlockingQueueTest {

    public static void main(String[] args) {
        ArrayBlockingQueue aqueue = new ArrayBlockingQueue(1);
        LinkedBlockingDeque deque = new LinkedBlockingDeque();
        LinkedBlockingQueueTest queue = new LinkedBlockingQueueTest();
        ConcurrentLinkedQueue cqueue = new ConcurrentLinkedQueue();
        ConcurrentLinkedDeque cdeque = new ConcurrentLinkedDeque();

        /**
         * 4. Queue
         ArrayQueue
         BlockingQueue<I>
         DelayQueue
         ArrayBlockingQueue
         ConcurrentLinkedQueue
         PriorityQueue
         PriorityBlockingQueue
         SynchronousQueue
         TransferQueue<I>
         LinkedTransferQueue
         */
        /*
        Deque
        ArrayDeque
        BlockingDeque
        LinkedBlockingDeque
        ConcurrentLinkedDeque
        */

        PriorityQueue pqueue = new PriorityQueue();
        PriorityBlockingQueue pbq = new PriorityBlockingQueue();

        ArrayDeque ad = new ArrayDeque();
        ArrayQueue aq = new ArrayQueue(1);

        WeakHashMap<String, String> whm = new WeakHashMap<>();
        IdentityHashMap ihm = new IdentityHashMap();
        LinkedHashMap lhm = new LinkedHashMap();
        LinkedHashSet lhs = new LinkedHashSet();

//        EnumSet es = new E
        Stack s = new Stack();

//        Deque
//        EnumMap

    }

}
