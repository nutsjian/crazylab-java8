package org.crazylab.java8.lock;

import java.util.concurrent.atomic.AtomicMarkableReference;

public class AtomicMarkableReferenceDemo01 {

    public static void main(String[] args) {
        AtomicMarkableReference<String> reference = new AtomicMarkableReference<>("123", true);
        boolean flag = reference.compareAndSet("123", "456", true, false);
        System.out.println(flag);
        System.out.println(reference.getReference());
    }

}
