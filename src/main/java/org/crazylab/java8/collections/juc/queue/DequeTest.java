package org.crazylab.java8.collections.juc.queue;


import java.util.ArrayDeque;

public class DequeTest {

    public static void main(String[] args) {
        ArrayDeque<String> ad = new ArrayDeque<>();
        // 报错，不允许元素是 null
//        ad.add(null);

        // add() -> addLast()
        ad.add("a");
        // offer -> offerLast() -> addLast
        ad.offer("b");

        // poll() -> pollFirst()
        // 获取并删除队首元素，失败返回 null
        ad.poll();



        // element() -> getFirst()
        // 获取但不删除队首元素，如果队首元素为null，则报NoSushElementException
        ad.element();

        // Stack 相关方法
        // push() -> addFirst()
        ad.push("ccc");

        // pop() -> removeFirst() -> pollFirst()
        // 获取并删除队首元素
        ad.pop();

        // peek() -> peekFirst()
        // 获取但不删除队首元素
        ad.peek();
    }
}
